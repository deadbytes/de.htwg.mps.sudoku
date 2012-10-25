package de.htwg.sudoku.fun.entities

import scala.math.sqrt
import scala.util.Random

class Cell(val value: Int, given: Boolean = false, showCandidates: Boolean = false) {
  def ==(v: Int) = if (value == v) true else false
  def isSet = value != 0
  override def toString = value.toString.replace('0', '.')
}

class House(cs: Vector[Cell]) {
  def cells(index: Int) = cs(index)
  override def toString = cs.mkString
  def toSet = cs.map(c => c.value).toSet
}

class Grid(cells: Vector[Cell]) {
  def this(blocksize: Int) = this(Vector.fill(blocksize * blocksize)(new Cell(0)))

  val size = sqrt(cells.size).toInt
  val blocknum = sqrt(size).toInt
  def blockAt(row: Int, col: Int) = (col / blocknum) + (row / blocknum) * blocknum
  def indexToRowCol(index: Int) = { val r = index / size; val c = index % size; (r, c) }
  def cell(row: Int, col: Int) = rows(row).cells(col)
  def rows(row: Int) = new House(cells.slice(size * row, size * (row + 1)))
  def cols(col: Int) = new House((for (row <- 0 until size) yield cell(row, col)).asInstanceOf[Vector[Cell]])
  def blocks(block: Int) = new House((for (row <- 0 until (size); col <- 0 until size; if blockAt(row, col) == block) yield cell(row, col)).asInstanceOf[Vector[Cell]])
  def set(row: Int, col: Int, value: Int) = new Grid(cells.updated(size * row + col, new Cell(value)))
  def unset(row: Int, col: Int) = set(row, col, 0)
  def available(row: Int, col: Int) = if (cell(row, col).isSet) Set.empty else (1 to size).toSet -- rows(row).toSet -- cols(col).toSet -- blocks(blockAt(row, col)).toSet
  def options = for (row <- 0 until size; col <- 0 until size) yield available(row, col)
  override def toString = {
    val lineseparator = ("+-" + ("--" * blocknum)) * blocknum + "+\n"
    val line = ("| " + ("x " * blocknum)) * blocknum + "|\n"
    var box = " \n" + (lineseparator + (line * blocknum)) * blocknum + lineseparator
    for (row <- 0 until size; col <- 0 until size) {
      (box = box.replaceFirst("x", cell(row, col).toString))
    }
    box
  }
  def reset = new Grid(size);
  def createRandom(num: Int): Grid = num match {
    case 0 => setRandom
    case _ => setRandom.createRandom(num - 1)
  }
  def setRandom = {
    val r = Random.nextInt(size)
    val c = Random.nextInt(size)
    val avail = available(r, c)
    val numAvail = avail.size
    if (numAvail > 0) {
      val v = avail.toIndexedSeq.apply(1)
      set(r, c, v)
    } else this

  }
  def solved = cells.forall(cell => cell.isSet)
  def unsolvable = options.isEmpty
  def solve: Grid = solve(0)._2
  def solve(index: Int): Pair[Boolean, Grid] = {
    if (solved) return (true, this) else if (unsolvable) return (false, this) else {
      val (row, col) = indexToRowCol(index)
      if (cell(row, col).isSet) return solve(index + 1) else {
        val iter = available(row, col).iterator
        var res: Pair[Boolean, Grid] = (false, this)
        if (iter.hasNext) {
          for (v <- iter) {
            res = set(row, col, v).solve(index + 1)
            if (res._1 == true) return res
          }
        } 
        return res
      }
    }
  }

}