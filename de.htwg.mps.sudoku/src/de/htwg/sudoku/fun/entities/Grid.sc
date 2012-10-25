import de.htwg.sudoku.fun.entities.Grid
import scala.math.sqrt

object SGrid {


  val grid = new Grid(4)                          //> grid  : de.htwg.sudoku.fun.entities.Grid =  
                                                  //| +-----+-----+
                                                  //| | . . | . . |
                                                  //| | . . | . . |
                                                  //| +-----+-----+
                                                  //| | . . | . . |
                                                  //| | . . | . . |
                                                  //| +-----+-----+
                                                  //| 
  grid.size                                       //> res0: Int = 4
  grid.blocknum                                   //> res1: Int = 2
  grid.rows(0)                                    //> res2: de.htwg.sudoku.fun.entities.House = ....
  grid.rows(2)                                    //> res3: de.htwg.sudoku.fun.entities.House = ....

  val grid2 = grid.set(0, 0, 1)                   //> grid2  : de.htwg.sudoku.fun.entities.Grid =  
                                                  //| +-----+-----+
                                                  //| | 1 . | . . |
                                                  //| | . . | . . |
                                                  //| +-----+-----+
                                                  //| | . . | . . |
                                                  //| | . . | . . |
                                                  //| +-----+-----+
                                                  //| 
  grid2.toString                                  //> res4: java.lang.String = " 
                                                  //| +-----+-----+
                                                  //| | 1 . | . . |
                                                  //| | . . | . . |
                                                  //| +-----+-----+
                                                  //| | . . | . . |
                                                  //| | . . | . . |
                                                  //| +-----+-----+
                                                  //| "
  grid2.rows(0)                                   //> res5: de.htwg.sudoku.fun.entities.House = 1...

  grid2.cols(0)                                   //> res6: de.htwg.sudoku.fun.entities.House = 1...

  val grid3 = grid2.set(0, 3, 2)                  //> grid3  : de.htwg.sudoku.fun.entities.Grid =  
                                                  //| +-----+-----+
                                                  //| | 1 . | . 2 |
                                                  //| | . . | . . |
                                                  //| +-----+-----+
                                                  //| | . . | . . |
                                                  //| | . . | . . |
                                                  //| +-----+-----+
                                                  //| 

  grid3.rows(0)                                   //> res7: de.htwg.sudoku.fun.entities.House = 1..2
  grid3.cols(3)                                   //> res8: de.htwg.sudoku.fun.entities.House = 2...
  grid3.blocks(0)                                 //> res9: de.htwg.sudoku.fun.entities.House = 1...
  grid3.blocks(1)                                 //> res10: de.htwg.sudoku.fun.entities.House = .2..
  grid3.rows(0).toSet                             //> res11: scala.collection.immutable.Set[Int] = Set(1, 0, 2)
  grid3.available(0, 1)                           //> res12: scala.collection.immutable.Set[_20048] = Set(3, 4)
  grid3.available(1, 1)                           //> res13: scala.collection.immutable.Set[_20048] = Set(2, 3, 4)
  grid3.available(2, 2)                           //> res14: scala.collection.immutable.Set[_20048] = Set(1, 2, 3, 4)
  grid3.options                                   //> res15: scala.collection.immutable.IndexedSeq[scala.collection.immutable.Set[
                                                  //| _ <: Int]] = Vector(Set(), Set(3, 4), Set(3, 4), Set(), Set(2, 3, 4), Set(2,
                                                  //|  3, 4), Set(1, 3, 4), Set(1, 3, 4), Set(2, 3, 4), Set(1, 2, 3, 4), Set(1, 2,
                                                  //|  3, 4), Set(1, 3, 4), Set(2, 3, 4), Set(1, 2, 3, 4), Set(1, 2, 3, 4), Set(1,
                                                  //|  3, 4))
 
  val grid1 = new Grid(1)                         //> grid1  : de.htwg.sudoku.fun.entities.Grid =  
                                                  //| +---+
                                                  //| | . |
                                                  //| +---+
                                                  //| 
  grid3.indexToRowCol(0)                          //> res16: (Int, Int) = (0,0)
  grid3.indexToRowCol(1)                          //> res17: (Int, Int) = (0,1)
  grid3.indexToRowCol(2)                          //> res18: (Int, Int) = (0,2)
  grid3.indexToRowCol(3)                          //> res19: (Int, Int) = (0,3)
  grid3.indexToRowCol(4)                          //> res20: (Int, Int) = (1,0)

  grid1.solve(0)                                  //> (001T)res21: (Boolean, de.htwg.sudoku.fun.entities.Grid) = (true, 
                                                  //| +---+
                                                  //| | 1 |
                                                  //| +---+
                                                  //| )
  var unsolved = new Grid(4).set(0,0,4).set(0,1,3).set(0,2,2).set(0,3,1).set(1,0,2).set(1,1,1).set(1,3,4).set(3,3,3)
                                                  //> unsolved  : de.htwg.sudoku.fun.entities.Grid =  
                                                  //| +-----+-----+
                                                  //| | 4 3 | 2 1 |
                                                  //| | 2 1 | . 4 |
                                                  //| +-----+-----+
                                                  //| | . . | . . |
                                                  //| | . . | . 3 |
                                                  //| +-----+-----+
                                                  //| 
 unsolved.options                                 //> res22: scala.collection.immutable.IndexedSeq[scala.collection.immutable.Set[
                                                  //| _ <: Int]] = Vector(Set(), Set(), Set(), Set(), Set(), Set(), Set(3), Set(),
                                                  //|  Set(1, 3), Set(2, 4), Set(1, 4), Set(2), Set(1), Set(2, 4), Set(1, 4), Set(
                                                  //| ))
 unsolved.solved                                  //> res23: Boolean = false
 unsolved.unsolvable                              //> res24: Boolean = false
 unsolved.solve                                   //> (123(201(212(224F)F)(214F)F)(203(212(221F)(224F)F)(214(221(232(301(312(324T)
                                                  //| T)T)T)T)T)T)T)res25: de.htwg.sudoku.fun.entities.Grid =  
                                                  //| +-----+-----+
                                                  //| | 4 3 | 2 1 |
                                                  //| | 2 1 | 3 4 |
                                                  //| +-----+-----+
                                                  //| | 3 4 | 1 2 |
                                                  //| | 1 2 | 4 3 |
                                                  //| +-----+-----+
                                                  //| 
  grid3.solve                                     //> (013(024(102(114(121(133(203(211(222(234(304(312(323(331T)T)T)T)T)T)T)T)T)T)
                                                  //| T)T)T)T)res26: de.htwg.sudoku.fun.entities.Grid =  
                                                  //| +-----+-----+
                                                  //| | 1 3 | 4 2 |
                                                  //| | 2 4 | 1 3 |
                                                  //| +-----+-----+
                                                  //| | 3 1 | 2 4 |
                                                  //| | 4 2 | 3 1 |
                                                  //| +-----+-----+
                                                  //| 
  val grid4 = new Grid(9)                         //> grid4  : de.htwg.sudoku.fun.entities.Grid =  
                                                  //| +-------+-------+-------+
                                                  //| | . . . | . . . | . . . |
                                                  //| | . . . | . . . | . . . |
                                                  //| | . . . | . . . | . . . |
                                                  //| +-------+-------+-------+
                                                  //| | . . . | . . . | . . . |
                                                  //| | . . . | . . . | . . . |
                                                  //| | . . . | . . . | . . . |
                                                  //| +-------+-------+-------+
                                                  //| | . . . | . . . | . . . |
                                                  //| | . . . | . . . | . . . |
                                                  //| | . . . | . . . | . . . |
                                                  //| +-------+-------+-------+
                                                  //| 
  grid4.solve                                     //> (005(011(026(039(042(057(063(078(084(109(112(127(135(141(156F)(153(166F)F)(1
                                                  //| 58(166F)F)(154(166F)F)F)(146(151F)(153(161F)F)(158(161F)F)(154(161F)F)F)(143
                                                  //| (151(166F)F)(156(161F)F)(158(161(176F)F)(166(171F)F)F)(154(161(176F)F)(166(1
                                                  //| 71F)F)F)F)(148(151(166F)F)(156(161F)F)(153(161(176F)F)(166(171F)F)F)(154(161
                                                  //| (176F)F)(166(171F)F)F)F)(144(151(166F)F)(156(161F)F)(153(161(176F)F)(166(171
                                                  //| F)F)F)(158(161(176F)F)(166(171F)F)F)F)F)(131(145(156F)(153(166F)F)(158(166F)
                                                  //| F)(154(166F)F)F)(146(155F)(153(165F)F)(158(165F)F)(154(165F)F)F)(143(155(166
                                                  //| F)F)(156(165F)F)(158(165(176F)F)(166(175F)F)F)(154(165(176F)F)(166(175F)F)F)
                                                  //| F)(148(155(166F)F)(156(165F)F)(153(165(176F)F)(166(175F)F)F)(154(165(176F)F)
                                                  //| (166(175F)F)F)F)(144(155(166F)F)(156(165F)F)(153(165(176F)F)(166(175F)F)F)(1
                                                  //| 58(165(176F)F)(166(175F)F)F)F)F)(136(145(151F)(153(161F)F)(158(161F)F)(154(1
                                                  //| 61F)F)F)(141(155F)(153(165F)F)(158(165F)F)(154(165F)F)F)(143(155(161F)F)(151
                                                  //| (165F)F)(158(165(171F)F)(161(175F)F)F)(154(165(171F)F)(161(175F)F)F)F)(148(1
                                                  //| 55(161F)F)(151(165F)F)(153(165(171F)F)(161(175F)F)F)(154(165(171F)F)(161(175
                                                  //| F)F)F)F)(144(155(161F)F)(151(165F)F)(153(165(171F)F)(161(175F)F)F)(158(165(1
                                                  //| 71F)F)(161(175F)F)F)F)F)(133(145(151(166F)F)(156(161F)F)(158(161(176F)F)(166
                                                  //| (171F)F)F)(154(161(176F)F)(166(171F)F)F)F)(141(155(166F)F)(156(165F)F)(158(1
                                                  //| 65(176F)F)(166(175F)F)F)(154(165(176F)F)(166(175F)F)F)F)(146(155(161F)F)(151
                                                  //| (165F)F)(158(165(171F)F)(161(175F)F)F)(154(165(171F)F)(161(175F)F)F)F)(148(1
                                                  //| 55(161(176F)F)(166(171F)F)F)(151(165(176F)F)(166(175F)F)F)(156(165(171F)F)(1
                                                  //| 61(175F)F)F)(154(165(171(186(203(218(224(235(241(256(269(272(287(301(315(329
                                                  //| (336(347(352(368(373F)(374(383(406(417(422(431(445(459F)(453F)(458F)F)(449(4
                                                  //| 55F)(453F)(458F)F)(443(455F)(459F)(458F)F)(444(455F)(459F)(453F)(458F)F)F)(4
                                                  //| 38(445(451F)(459(461F)F)(453(461(479F)F)F)F)(449(455(461F)F)(451F)(453(461(4
                                                  //| 75F)F)F)F)(443(455(461(479F)F)F)(451F)(459(461(475F)F)F)F)(444(455(461(479F)
                                                  //| F)F)(451F)(459(461(475F)F)F)(453(461(475(489(508(513F)(514(523(531(545(559(5
                                                  //| 66(577(582(602(616(625(637(649(651(664(673(688(707(719(721(732(746(755F)(758
                                                  //| F)F)(743(755F)(758F)F)F)(734(746(755(762F)F)(758(762F)F)F)(743(755(762(776F)
                                                  //| F)F)(758(762(776(785(804(813(828(832(846(855(867(879(881T)T)T)T)T)T)T)T)T)T)
                                                  //| T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)
                                                  //| T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)T)res27: de.
                                                  //| htwg.sudoku.fun.entities.Grid =  
                                                  //| +-------+-------+-------+
                                                  //| | 5 1 6 | 9 2 7 | 3 8 4 |
                                                  //| | 9 2 7 | 3 8 4 | 5 1 6 |
                                                  //| | 3 8 4 | 5 1 6 | 9 2 7 |
                                                  //| +-------+-------+-------+
                                                  //| | 1 5 9 | 6 7 2 | 8 4 3 |
                                                  //| | 6 7 2 | 8 4 3 | 1 5 9 |
                                                  //| | 8 4 3 | 1 5 9 | 6 7 2 |
                                                  //| +-------+-------+-------+
                                                  //| | 2 6 5 | 7 9 1 | 4 3 8 |
                                                  //| | 7 9 1 | 4 3 8 | 2 6 5 |
                                                  //| | 4 3 8 | 2 6 5 | 7 9 1 |
                                                  //| +-------+-------+-------+
                                                  //| 
    

}