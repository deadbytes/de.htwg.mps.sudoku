package de.htwg.sudoku.model.impl

import de.htwg.sudoku.model.{Cell=>CellTrait}

class Cell(val value: Int, var isGiven:Boolean) extends CellTrait {
  
  def this(value:Int) = this(value, false)
  
  var isHighlighted: Boolean = false
  var isShowingCandidates = false
  def showCandidates = isShowingCandidates=true
  def given=if (isSet) isGiven =true
  def notGiven = isGiven = false
  def highlight = isHighlighted = true
  def unhighlight = isHighlighted = false
  def equals(that: Cell) = this.value == that.value
  def ==(v: Int) = if (value == v) true else false
  def isSet = value != 0
  override def toString = value.toString.replace('0', ' ')
} 