package de.htwg.sudoku.model.fun

class Cell(val value: Int, given: Boolean = false, showCandidates: Boolean = false) {
  def ==(v: Int) = if (value == v) true else false
  def isSet = value != 0
  override def toString = value.toString.replace('0', '.')
}