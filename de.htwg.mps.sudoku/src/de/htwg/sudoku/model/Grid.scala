package de.htwg.sudoku.model

trait Grid {
  def set(row: Int, col: Int, value: Int):Grid
  def blocknum:Int
  def size:Int
  def available(row:Int, col:Int):Set[Int]
  def cell(row:Int, col:Int): Cell
  def highlight(index:Int): Unit
  def createRandom(size:Int):Grid
  def setGiven:Unit
  def parseFromString(s:String): Grid
  def reset:Grid
  def solve:Pair[Boolean, Grid]
  def valid:Boolean
}
