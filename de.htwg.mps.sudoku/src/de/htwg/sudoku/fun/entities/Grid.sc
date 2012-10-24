import de.htwg.sudoku.entities._
import scala.math.sqrt

object SGrid {

  val grid = new SGrid(4)                         //> grid  : de.htwg.sudoku.entities.SGrid =  
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
  grid.rows(0)                                    //> res2: de.htwg.sudoku.entities.SHouse = ....
  grid.rows(2)                                    //> res3: de.htwg.sudoku.entities.SHouse = ....

  val grid2 = grid.set(0, 0, 1)                   //> grid2  : de.htwg.sudoku.entities.SGrid =  
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
  grid2.rows(0)                                   //> res5: de.htwg.sudoku.entities.SHouse = 1...

  grid2.cols(0)                                   //> res6: de.htwg.sudoku.entities.SHouse = 1...

  val grid3 = grid2.set(0, 3, 2)                  //> grid3  : de.htwg.sudoku.entities.SGrid =  
                                                  //| +-----+-----+
                                                  //| | 1 . | . 2 |
                                                  //| | . . | . . |
                                                  //| +-----+-----+
                                                  //| | . . | . . |
                                                  //| | . . | . . |
                                                  //| +-----+-----+
                                                  //| 

  grid3.rows(0)                                   //> res7: de.htwg.sudoku.entities.SHouse = 1..2
  grid3.cols(3)                                   //> res8: de.htwg.sudoku.entities.SHouse = 2...
  grid3.blocks(0)                                 //> res9: de.htwg.sudoku.entities.SHouse = 1...
  grid3.blocks(1)                                 //> res10: de.htwg.sudoku.entities.SHouse = .2..
  grid3.rows(0).toSet                             //> res11: scala.collection.immutable.Set[Int] = Set(1, 0, 2)
  grid3.available(0, 1)                           //> res12: scala.collection.immutable.Set[_27778] = Set(3, 4)
  grid3.available(1, 1)                           //> res13: scala.collection.immutable.Set[_27778] = Set(2, 3, 4)
  grid3.available(2, 2)                           //> res14: scala.collection.immutable.Set[_27778] = Set(1, 2, 3, 4)
  var s = Set(1, 2, 3, 4) -- Set(1, 2)            //> s  : scala.collection.immutable.Set[Int] = Set(3, 4)

  val grid1 = new SGrid(1)                        //> grid1  : de.htwg.sudoku.entities.SGrid =  
                                                  //| +---+
                                                  //| | . |
                                                  //| +---+
                                                  //| 
  grid3.indexToRowCol(0)                          //> res15: (Int, Int) = (0,0)
  grid3.indexToRowCol(1)                          //> res16: (Int, Int) = (0,1)
  grid3.indexToRowCol(2)                          //> res17: (Int, Int) = (0,2)
  grid3.indexToRowCol(3)                          //> res18: (Int, Int) = (0,3)
  grid3.indexToRowCol(4)                          //> res19: (Int, Int) = (1,0)

  grid1.solve(0)                                  //> res20: (Boolean, de.htwg.sudoku.entities.SGrid) = (true, 
                                                  //| +---+
                                                  //| | 1 |
                                                  //| +---+
                                                  //| )
  grid3.solve                                     //> res21: (Boolean, de.htwg.sudoku.entities.SGrid) = (false, 
                                                  //| +-----+-----+
                                                  //| | 1 . | . 2 |
                                                  //| | . . | . . |
                                                  //| +-----+-----+
                                                  //| | . . | . . |
                                                  //| | . . | . . |
                                                  //| +-----+-----+
                                                  //| )
  val grid4 = new SGrid(9)                        //> grid4  : de.htwg.sudoku.entities.SGrid =  
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
  grid4.solve                                     //> res22: (Boolean, de.htwg.sudoku.entities.SGrid) = (true, 
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
                                                  //| )

}