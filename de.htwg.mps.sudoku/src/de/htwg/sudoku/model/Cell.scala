package de.htwg.sudoku.model

trait Cell {
  var isShowingCandidates:Boolean
  def showCandidates:Unit
  def isGiven:Boolean
  def isSet:Boolean
  def isHighlighted:Boolean
}