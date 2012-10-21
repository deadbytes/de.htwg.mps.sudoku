import de.htwg.sudoku.entities._
object EntitiesWorkSheet {

  val cell = new Cell(1, 2)                       //> cell  : de.htwg.sudoku.entities.Cell =  
  cell.toString                                   //> res0: java.lang.String = " "
  cell.mkString                                   //> res1: java.lang.String = (1, 2) = 0
  cell := 9
  cell.mkString                                   //> res2: java.lang.String = (1, 2) = 9
  cell == 9                                       //> res3: Boolean = true
  cell.x                                          //> res4: Int = 1
  cell.y                                          //> res5: Int = 2

  val house1 = new House(1)                       //> house1  : de.htwg.sudoku.entities.House = |   |
  house1.candidateSet                             //> res6: scala.collection.immutable.Set[Int] = Set(1)

  val house4 = new House(4)                       //> house4  : de.htwg.sudoku.entities.House = |     |     |
  house4.candidateSet                             //> res7: scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)

  val house9 = new House(9)                       //> house9  : de.htwg.sudoku.entities.House = |       |       |       |
  house9.candidateSet                             //> res8: scala.collection.immutable.Set[Int] = Set(5, 1, 6, 9, 2, 7, 3, 8, 4)

  val grid1 = new Grid(1)                         //> grid1  : de.htwg.sudoku.entities.Grid = +---+
                                                  //| |   |
                                                  //| +---+
                                                  //| 
  grid1.solve                                     //> res9: Boolean = true
  grid1.toString                                  //> res10: java.lang.String = "+---+
                                                  //| | 1 |
                                                  //| +---+
                                                  //| "

  val grid4 = new Grid(4)                         //> grid4  : de.htwg.sudoku.entities.Grid = +-----+-----+
                                                  //| |     |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| |     |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| 
  grid4.candidateSet(0, 0)                        //> res11: scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)
  grid4.set(0, 0, 2)                              //> res12: Boolean = true
  grid4.solve                                     //> res13: Boolean = true
  grid4.toString                                  //> res14: java.lang.String = "+-----+-----+
                                                  //| | 2 3 | 1 4 |
                                                  //| | 1 4 | 2 3 |
                                                  //| +-----+-----+
                                                  //| | 3 1 | 4 2 |
                                                  //| | 4 2 | 3 1 |
                                                  //| +-----+-----+
                                                  //| "

  val grid9 = new Grid(9)                         //> grid9  : de.htwg.sudoku.entities.Grid = +-------+-------+-------+
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
  grid9.solve                                     //> res15: Boolean = true
  grid9.toString                                  //> res16: java.lang.String = "+-------+-------+-------+
                                                  //| | 1 4 7 | 2 3 8 | 5 6 9 |
                                                  //| | 2 5 8 | 1 6 9 | 3 4 7 |
                                                  //| | 3 6 9 | 4 5 7 | 1 2 8 |
                                                  //| +-------+-------+-------+
                                                  //| | 4 7 1 | 3 8 2 | 6 9 5 |
                                                  //| | 5 8 2 | 6 9 1 | 4 7 3 |
                                                  //| | 6 9 3 | 5 7 4 | 2 8 1 |
                                                  //| +-------+-------+-------+
                                                  //| | 7 1 4 | 8 2 3 | 9 5 6 |
                                                  //| | 8 2 5 | 9 1 6 | 7 3 4 |
                                                  //| | 9 3 6 | 7 4 5 | 8 1 2 |
                                                  //| +-------+-------+-------+
                                                  //| "
  grid9.reset
  grid9.createRandom(18)
  grid9.toString                                  //> res17: java.lang.String = "+-------+-------+-------+
                                                  //| |   9   |     8 |       |
                                                  //| | 8     |       |       |
                                                  //| |     3 |     7 |       |
                                                  //| +-------+-------+-------+
                                                  //| |     1 |       |       |
                                                  //| | 3     |     4 | 1     |
                                                  //| |       | 2     |       |
                                                  //| +-------+-------+-------+
                                                  //| |       |       | 9 2   |
                                                  //| |   5 9 |       |       |
                                                  //| |       |   2   |       |
                                                  //| +-------+-------+-------+
                                                  //| "
  grid9.solve                                     //> res18: Boolean = true
  grid9.toString                                  //> res19: java.lang.String = "+-------+-------+-------+
                                                  //| | 1 9 5 | 3 4 8 | 2 6 7 |
                                                  //| | 8 6 7 | 1 9 2 | 4 5 3 |
                                                  //| | 4 2 3 | 5 6 7 | 8 1 9 |
                                                  //| +-------+-------+-------+
                                                  //| | 5 4 1 | 6 3 9 | 7 8 2 |
                                                  //| | 3 7 2 | 8 5 4 | 1 9 6 |
                                                  //| | 9 8 6 | 2 7 1 | 5 3 4 |
                                                  //| +-------+-------+-------+
                                                  //| | 6 1 4 | 7 8 3 | 9 2 5 |
                                                  //| | 2 5 9 | 4 1 6 | 3 7 8 |
                                                  //| | 7 3 8 | 9 2 5 | 6 4 1 |
                                                  //| +-------+-------+-------+
                                                  //| "
}