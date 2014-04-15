 package de.htwg.sudoku.model.impl

import scala.math.sqrt
import scala.io.Source._

object GridWS {


  val grid = new Grid(4)                          //> grid  : de.htwg.sudoku.model.impl.Grid = 
                                                  //| +-----+-----+
                                                  //| |     |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| |     |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| 
  grid.size                                       //> res0: Int = 4
  grid.blocknum                                   //> res1: Int = 2
  grid.rows(0)                                    //> res2: de.htwg.sudoku.model.impl.House =     
  grid.rows(2)                                    //> res3: de.htwg.sudoku.model.impl.House =     

  val grid2 = grid.set(0, 0, 1)                   //> grid2  : de.htwg.sudoku.model.impl.Grid = 
                                                  //| +-----+-----+
                                                  //| | 1   |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| |     |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| 
  grid2.toString                                  //> res4: String = "
                                                  //| +-----+-----+
                                                  //| | 1   |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| |     |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| "
  grid2.rows(0)                                   //> res5: de.htwg.sudoku.model.impl.House = 1   

  grid2.cols(0)                                   //> res6: de.htwg.sudoku.model.impl.House = 1   

  val grid3 = grid2.set(0, 3, 2)                  //> grid3  : de.htwg.sudoku.model.impl.Grid = 
                                                  //| +-----+-----+
                                                  //| | 1   |   2 |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| |     |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| 

  grid3.rows(0)                                   //> res7: de.htwg.sudoku.model.impl.House = 1  2
  grid3.cols(3)                                   //> res8: de.htwg.sudoku.model.impl.House = 2   
  grid3.blocks(0)                                 //> res9: de.htwg.sudoku.model.impl.House = 1   
  grid3.blocks(1)                                 //> res10: de.htwg.sudoku.model.impl.House =  2  

  grid3.available(0, 1)                           //> res11: Set[Int] = Set(3, 4)
  grid3.available(1, 1)                           //> res12: Set[Int] = Set(2, 3, 4)
  grid3.available(2, 2)                           //> res13: Set[Int] = Set(1, 2, 3, 4)
  grid3.options                                   //> res14: scala.collection.immutable.IndexedSeq[Set[Int]] = Vector(Set(), Set(3
                                                  //| , 4), Set(3, 4), Set(), Set(2, 3, 4), Set(2, 3, 4), Set(1, 3, 4), Set(1, 3, 
                                                  //| 4), Set(2, 3, 4), Set(1, 2, 3, 4), Set(1, 2, 3, 4), Set(1, 3, 4), Set(2, 3, 
                                                  //| 4), Set(1, 2, 3, 4), Set(1, 2, 3, 4), Set(1, 3, 4))
 
  val grid1 = new Grid(1)                         //> grid1  : de.htwg.sudoku.model.impl.Grid = 
                                                  //| +---+
                                                  //| |   |
                                                  //| +---+
                                                  //| 
  grid3.indexToRowCol(0)                          //> res15: (Int, Int) = (0,0)
  grid3.indexToRowCol(1)                          //> res16: (Int, Int) = (0,1)
  grid3.indexToRowCol(2)                          //> res17: (Int, Int) = (0,2)
  grid3.indexToRowCol(3)                          //> res18: (Int, Int) = (0,3)
  grid3.indexToRowCol(4)                          //> res19: (Int, Int) = (1,0)

  grid1.solve(0)                                  //> res20: (Boolean, de.htwg.sudoku.model.impl.Grid) = (true,
                                                  //| +---+
                                                  //| | 1 |
                                                  //| +---+
                                                  //| )
  var unsolved = new Grid(4).set(0,0,4).set(0,1,3).set(0,2,2).set(0,3,1).set(1,0,2).set(1,1,1).set(1,3,4).set(3,3,3)
                                                  //> unsolved  : de.htwg.sudoku.model.impl.Grid = 
                                                  //| +-----+-----+
                                                  //| | 4 3 | 2 1 |
                                                  //| | 2 1 |   4 |
                                                  //| +-----+-----+
                                                  //| |     |     |
                                                  //| |     |   3 |
                                                  //| +-----+-----+
                                                  //| 
 unsolved.options                                 //> res21: scala.collection.immutable.IndexedSeq[Set[Int]] = Vector(Set(), Set()
                                                  //| , Set(), Set(), Set(), Set(), Set(3), Set(), Set(1, 3), Set(2, 4), Set(1, 4)
                                                  //| , Set(2), Set(1), Set(2, 4), Set(1, 4), Set())
 unsolved.solved                                  //> res22: Boolean = false
 unsolved.unsolvable                              //> res23: Boolean = false
 unsolved.solve                                   //> res24: (Boolean, de.htwg.sudoku.model.impl.Grid) = (true,
                                                  //| +-----+-----+
                                                  //| | 4 3 | 2 1 |
                                                  //| | 2 1 | 3 4 |
                                                  //| +-----+-----+
                                                  //| | 3 4 | 1 2 |
                                                  //| | 1 2 | 4 3 |
                                                  //| +-----+-----+
                                                  //| )
  grid3.solve                                     //> res25: (Boolean, de.htwg.sudoku.model.impl.Grid) = (true,
                                                  //| +-----+-----+
                                                  //| | 1 4 | 3 2 |
                                                  //| | 3 2 | 4 1 |
                                                  //| +-----+-----+
                                                  //| | 2 3 | 1 4 |
                                                  //| | 4 1 | 2 3 |
                                                  //| +-----+-----+
                                                  //| )
  val grid4 = new Grid(9)                         //> grid4  : de.htwg.sudoku.model.impl.Grid = 
                                                  //| +-------+-------+-------+
                                                  //| |       |       |       |
                                                  //| |       |       |       |
                                                  //| |       |       |       |
                                                  //| +-------+-------+-------+
                                                  //| |       |       |       |
                                                  //| |       |       |       |
                                                  //| |       |       |       |
                                                  //| +-------+-------+-------+
                                                  //| |       |       |       |
                                                  //| |       |       |       |
                                                  //| |       |       |       |
                                                  //| +-------+-------+-------+
                                                  //| 
  grid4.solve                                     //> res26: (Boolean, de.htwg.sudoku.model.impl.Grid) = (true,
                                                  //| +-------+-------+-------+
                                                  //| | 7 4 8 | 3 9 6 | 5 1 2 |
                                                  //| | 3 1 2 | 5 4 7 | 8 9 6 |
                                                  //| | 9 5 6 | 1 2 8 | 4 3 7 |
                                                  //| +-------+-------+-------+
                                                  //| | 4 3 1 | 2 5 9 | 7 6 8 |
                                                  //| | 2 6 7 | 8 3 4 | 1 5 9 |
                                                  //| | 5 8 9 | 7 6 1 | 3 2 4 |
                                                  //| +-------+-------+-------+
                                                  //| | 6 2 3 | 4 7 5 | 9 8 1 |
                                                  //| | 1 9 4 | 6 8 3 | 2 7 5 |
                                                  //| | 8 7 5 | 9 1 2 | 6 4 3 |
                                                  //| +-------+-------+-------+
                                                  //| )
                                                  
	//Compare times on solve for single and concurrent execution
//	val grids = (for(i <- 1 to 5) yield new Grid(9).createRandom(9)).toList
//	val grids2 = grids map(_.deepCopy)
//	def getTime(f: => (Boolean, Grid)) = {
//		val start = System.currentTimeMillis()
//		f
//		val end = System.currentTimeMillis()
//		end - start
//	}
//	grids.map(g => getTime(g.solve(0)))
//	grids2.map(g => getTime(g.solve))

}