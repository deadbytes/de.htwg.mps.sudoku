package de.htwg.sudoku.entities

import scala.math.sqrt 

class Grid(size: Int) {
  require(List(1, 4, 9).contains(size))
  val block = sqrt(size).toInt
  val sr = sqrt(size).toInt
  var cells = Array.ofDim[Cell](size, size) 

  var rows = new Array[House](size)
  var columns = new Array[House](size)
  var blocks = new Array[House](size)

  for (index <- 0 until size) {
    rows(index) = new House(size)
    columns(index) = new House(size)
    blocks(index) = new House(size)
  }

  for (row <- 0 until size; column <- 0 until size) {
    cells(row)(column) = new Cell(row, column)
    rows(row).cells(column) = cell(row, column)
    columns(column).cells(row) = cell(row, column)
    blocks(blockAt(row, column)).cells(cellInBlockAt(row, column)) = cell(row, column)
  }

  def reset = {
    for (row <- 0 until size; column <- 0 until size) {
      cell(row, column) := 0
    }
  }

  def cell(r: Int, c: Int) = cells(r)(c)

  def cellInBlockAt(row: Int, column: Int) = (row % sr + (column % sr) * sr)

  def blockAt(row: Int, column: Int) = (column / sr) + (row / sr) * sr

  def candidateSet(row: Int, column: Int) = {
    var s = rows(row).candidateSet. 
      intersect(columns(column).candidateSet).
      intersect(blocks(blockAt(row, column)).candidateSet)
    s
  }

  def set(row: Int, column: Int, value: Int, setGiven:Boolean=false): Boolean = {
    if (!cell(row,column).given && candidateSet(row, column).contains(value)) {
      cell(row, column) := value
	  if (setGiven) cell(row,column).given=true
      true
    }
    else false
  }

  def solve: Boolean = solve(0, 0)

  def solve(row: Int, column: Int): Boolean = {
    if (row == size) return true //reached end
    if (column == size) return solve(row + 1, 0)  //reached end of row -> switch to next row
    if (cell(row, column).isSet) return solve(row, column + 1)
    else {
      for (candidate <- 1 to size) {
        if (candidateSet(row, column).contains(candidate)) {
          var r = set(row, column, candidate)
          if (solve(row, column + 1)) return true
        }
      }
      cell(row, column) := 0;
      false
    }
  }

  override def toString = {
    var result =""
    columns.foreach(house => result+= (if (house.cells(0).y % block == 0) lineseparator else "" ) + house.toString() + "\n")
    result + lineseparator
  }
  
  def lineseparator = ("+-" + ("--"*block))*block + "+\n"
 
  def parseFromString(string: String) {
    reset
    var list = string.toList.filter(char => ('0' to '9').contains(char))
    for (row <- 0 until size; column <- 0 until size) {
      set(column, row, list.head.toString.toInt,setGiven=true)
      list = list.drop(1)
    }
  }
  
  def createRandom(difficulty: Int) {
    reset
    for (i <- 0 to difficulty) {
      val randomRow = scala.util.Random.nextInt(size)
      val randomColumn = scala.util.Random.nextInt(size)
      val randomValue = scala.util.Random.nextInt(size) + 1
      set(randomRow, randomColumn, randomValue,setGiven=true)
    }
  }
  
}
