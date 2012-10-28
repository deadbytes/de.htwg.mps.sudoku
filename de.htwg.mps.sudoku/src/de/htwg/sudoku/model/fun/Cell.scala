package de.htwg.sudoku.model.fun

class Cell(val value: Int, var showCandidates: Boolean = false) {
  var highlighted: Boolean = false
  var isGiven: Boolean = false
  def given=if (isSet) isGiven =true
  def notGiven = isGiven = false
  def highlight = highlighted = true
  def unhighlight = highlighted = false
  def equals(that: Cell) = this.value == that.value
  def ==(v: Int) = if (value == v) true else false
  def isSet = value != 0
  override def toString = value.toString.replace('0', ' ')
} 