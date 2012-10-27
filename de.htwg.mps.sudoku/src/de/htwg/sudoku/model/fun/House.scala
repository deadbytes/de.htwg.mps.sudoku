package de.htwg.sudoku.model.fun

class House(val cs: Vector[Cell]) {
  def cells(index: Int) = cs(index)
  override def toString = cs.mkString
  def toIntSet:Set[Int] = cs.filterNot(_.value==0).map(_.value).toSet
  def toIntList:List[Int] = cs.filterNot(_.value==0).map(_.value).toList
  def valid = this.toIntList == this.toIntSet.toList 
}