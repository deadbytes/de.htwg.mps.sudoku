package de.htwg.sudoku.model.imp

class Cell(row: Int, column: Int) {
  var value = 0
  var given = false
  var showCandidates = false

  def :=(v: Int) = value = v
  def ==(v: Int) = if (value == v) true else false
  def isSet = value != 0
  def x = row
  def y = column
  def mkString = "(" + row + ", " + column + ") = " + value
  override def toString = value.toString.replace('0', ' ')

}





