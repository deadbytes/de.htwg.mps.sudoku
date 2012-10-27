package de.htwg.sudoku.model.fun

import scala.math.sqrt
import scala.io.Source._

object GridWS {


  val grid = new Grid(4)                          //> grid  : de.htwg.sudoku.model.fun.Grid =  
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
  grid.rows(0)                                    //> res2: de.htwg.sudoku.model.fun.House = ....
  grid.rows(2)                                    //> res3: de.htwg.sudoku.model.fun.House = ....

  val grid2 = grid.set(0, 0, 1)                   //> grid2  : de.htwg.sudoku.model.fun.Grid =  
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
  grid2.rows(0)                                   //> res5: de.htwg.sudoku.model.fun.House = 1...

  grid2.cols(0)                                   //> res6: de.htwg.sudoku.model.fun.House = 1...

  val grid3 = grid2.set(0, 3, 2)                  //> grid3  : de.htwg.sudoku.model.fun.Grid =  
                                                  //| +-----+-----+
                                                  //| | 1 . | . 2 |
                                                  //| | . . | . . |
                                                  //| +-----+-----+
                                                  //| | . . | . . |
                                                  //| | . . | . . |
                                                  //| +-----+-----+
                                                  //| 

  grid3.rows(0)                                   //> res7: de.htwg.sudoku.model.fun.House = 1..2
  grid3.cols(3)                                   //> res8: de.htwg.sudoku.model.fun.House = 2...
  grid3.blocks(0)                                 //> res9: de.htwg.sudoku.model.fun.House = 1...
  grid3.blocks(1)                                 //> res10: de.htwg.sudoku.model.fun.House = .2..
  grid3.rows(0).toSet                             //> res11: scala.collection.immutable.Set[Int] = Set(1, 0, 2)
  grid3.available(0, 1)                           //> res12: scala.collection.immutable.Set[_1] = Set(3, 4)
  grid3.available(1, 1)                           //> res13: scala.collection.immutable.Set[_1] = Set(2, 3, 4)
  grid3.available(2, 2)                           //> res14: scala.collection.immutable.Set[_1] = Set(1, 2, 3, 4)
  grid3.options                                   //> res15: scala.collection.immutable.IndexedSeq[scala.collection.immutable.Set[
                                                  //| _ <: Int]] = Vector(Set(), Set(3, 4), Set(3, 4), Set(), Set(2, 3, 4), Set(2,
                                                  //|  3, 4), Set(1, 3, 4), Set(1, 3, 4), Set(2, 3, 4), Set(1, 2, 3, 4), Set(1, 2,
                                                  //|  3, 4), Set(1, 3, 4), Set(2, 3, 4), Set(1, 2, 3, 4), Set(1, 2, 3, 4), Set(1,
                                                  //|  3, 4))
 
  val grid1 = new Grid(1)                         //> grid1  : de.htwg.sudoku.model.fun.Grid =  
                                                  //| +---+
                                                  //| | . |
                                                  //| +---+
                                                  //| 
  grid3.indexToRowCol(0)                          //> res16: (Int, Int) = (0,0)
  grid3.indexToRowCol(1)                          //> res17: (Int, Int) = (0,1)
  grid3.indexToRowCol(2)                          //> res18: (Int, Int) = (0,2)
  grid3.indexToRowCol(3)                          //> res19: (Int, Int) = (0,3)
  grid3.indexToRowCol(4)                          //> res20: (Int, Int) = (1,0)

  grid1.solve(0)                                  //> res21: (Boolean, de.htwg.sudoku.model.fun.Grid) = (true, 
                                                  //| +---+
                                                  //| | 1 |
                                                  //| +---+
                                                  //| )
  var unsolved = new Grid(4).set(0,0,4).set(0,1,3).set(0,2,2).set(0,3,1).set(1,0,2).set(1,1,1).set(1,3,4).set(3,3,3)
                                                  //> unsolved  : de.htwg.sudoku.model.fun.Grid =  
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
 unsolved.solve                                   //> res25: (Boolean, de.htwg.sudoku.model.fun.Grid) = (true, 
                                                  //| +-----+-----+
                                                  //| | 4 3 | 2 1 |
                                                  //| | 2 1 | 3 4 |
                                                  //| +-----+-----+
                                                  //| | 3 4 | 1 2 |
                                                  //| | 1 2 | 4 3 |
                                                  //| +-----+-----+
                                                  //| )
  grid3.solve                                     //> res26: (Boolean, de.htwg.sudoku.model.fun.Grid) = (true, 
                                                  //| +-----+-----+
                                                  //| | 1 4 | 3 2 |
                                                  //| | 2 3 | 1 4 |
                                                  //| +-----+-----+
                                                  //| | 3 2 | 4 1 |
                                                  //| | 4 1 | 2 3 |
                                                  //| +-----+-----+
                                                  //| )
  val grid4 = new Grid(9)                         //> grid4  : de.htwg.sudoku.model.fun.Grid =  
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
  grid4.solve                                     //> res27: (Boolean, de.htwg.sudoku.model.fun.Grid) = (true, 
                                                  //| +-------+-------+-------+
                                                  //| | 7 9 3 | 2 6 4 | 1 8 5 |
                                                  //| | 6 1 2 | 3 5 8 | 7 4 9 |
                                                  //| | 4 5 8 | 1 9 7 | 2 6 3 |
                                                  //| +-------+-------+-------+
                                                  //| | 2 6 1 | 7 8 3 | 9 5 4 |
                                                  //| | 8 3 7 | 9 4 5 | 6 2 1 |
                                                  //| | 9 4 5 | 6 1 2 | 8 3 7 |
                                                  //| +-------+-------+-------+
                                                  //| | 1 2 9 | 4 3 6 | 5 7 8 |
                                                  //| | 3 8 6 | 5 7 1 | 4 9 2 |
                                                  //| | 5 7 4 | 8 2 9 | 3 1 6 |
                                                  //| +-------+-------+-------+
                                                  //| )

}