package de.htwg.sudoku.model

trait Cell {
  var showCandidates:Boolean
  def isGiven:Boolean
  def isSet:Boolean
  def isHighlighted:Boolean
}