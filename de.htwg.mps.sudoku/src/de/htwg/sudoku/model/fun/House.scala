package de.htwg.sudoku.model.fun

class House(cs: Vector[Cell]) {
  def cells(index: Int) = cs(index)
  override def toString = cs.mkString
  def toSet = cs.map(c => c.value).toSet
  def valid = cs.toList -- toSet.toList == List.empty
}