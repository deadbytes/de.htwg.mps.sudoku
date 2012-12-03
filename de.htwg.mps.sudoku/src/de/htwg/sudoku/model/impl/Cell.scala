package de.htwg.sudoku.model.impl

import de.htwg.sudoku.model.{Cell=>CellTrait}

class Cell(val value: Int, var showCandidates: Boolean = false) extends CellTrait {
  var isHighlighted: Boolean = false
  var isGiven: Boolean = false
  def given=if (isSet) isGiven =true
  def notGiven = isGiven = false
  def highlight = isHighlighted = true
  def unhighlight = isHighlighted = false
  def equals(that: Cell) = this.value == that.value
  def ==(v: Int) = if (value == v) true else false
  def isSet = value != 0
  override def toString = value.toString.replace('0', ' ')
} 