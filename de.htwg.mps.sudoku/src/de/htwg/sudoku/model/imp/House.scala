package de.htwg.sudoku.model.imp

import scala.math.sqrt

class House(size: Int) {
  require(List(1, 4, 9).contains(size))
  val block = sqrt(size)
  val cells=new Array[Cell](size)
  
  for (index <- 0 until size) {
    cells(index) = new Cell(index,0)
  }
  
  def candidateSet ={
    var s = (1 to size).toSet
    cells.foreach(cell => s= s - cell.value)
    s
  }

  override def toString = {
    var result =""
    cells.foreach(cell => result += (if (cell.x % block == 0 ) "| " else "" ) + cell.toString +" ") 
    result+"|"
  }

}