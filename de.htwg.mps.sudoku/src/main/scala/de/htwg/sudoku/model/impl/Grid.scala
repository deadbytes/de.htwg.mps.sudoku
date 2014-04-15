package de.htwg.sudoku.model.impl

import scala.math.sqrt
import scala.util.Random
import de.htwg.sudoku.model.{Grid=>GridTrait}
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class Grid(cells: Vector[Cell]) extends GridTrait{
  def this(blocksize: Int) = this(Vector.fill(blocksize * blocksize)(new Cell(0)))

  val size = sqrt(cells.size).toInt
  val blocknum = sqrt(size).toInt
  def blockAt(row: Int, col: Int) = (col / blocknum) + (row / blocknum) * blocknum
  def indexToRowCol(index: Int) = { val r = index / size; val c = index % size; (r, c) }
  def cell(row: Int, col: Int) = rows(row).cells(col)
  def rows(row: Int) = new House(cells.slice(size * row, size * (row + 1)))
  def allrows = (0 until size).map(i => rows(i))
  def cols(col: Int) = new House((for (row <- 0 until size) yield cell(row, col)).asInstanceOf[Vector[Cell]])
  def allcols = (0 until size).map(i => cols(i))
  def blocks(block: Int) = new House((for (row <- 0 until (size); col <- 0 until size; if blockAt(row, col) == block) yield cell(row, col)).asInstanceOf[Vector[Cell]])
  def allblocks = (0 until size).map(i => blocks(i))
  def set(row: Int, col: Int, value: Int):Grid = new Grid(cells.updated(size * row + col, new Cell(value)))
  def unset(row: Int, col: Int):Grid = set(row, col, 0)
  def available(row: Int, col: Int):Set[Int] = if (cell(row, col).isSet) Set.empty else (1 to size).toSet -- rows(row).toIntSet -- cols(col).toIntSet -- blocks(blockAt(row, col)).toIntSet
  def options = for (row <- 0 until size; col <- 0 until size) yield available(row, col)
  def valid = allrows.forall(house => house.valid) && allcols.forall(house => house.valid) && allblocks.forall(house => house.valid)
  def highlight(index:Int) = {
    for (row <- 0 until size; col<- 0 until size){
      if (available(row,col).contains(index)) cell(row,col).highlight else cell(row,col).unhighlight
    } 
  }
  def setGiven = {
    for (row <- 0 until size; col<- 0 until size){
      if (cell(row,col).isSet) cell(row,col).given else cell(row,col).notGiven
    } 
  }
  override def toString = {
    val lineseparator = ("+-" + ("--" * blocknum)) * blocknum + "+\n"
    val line = ("| " + ("x " * blocknum)) * blocknum + "|\n"
    var box = "\n" + (lineseparator + (line * blocknum)) * blocknum + lineseparator
    for (row <- 0 until size; col <- 0 until size) {
      (box = box.replaceFirst("x", cell(row, col).toString))
    }
    box
  }
  def reset = new Grid(size);
  def createRandom(num: Int): Grid = {
    def setRandom = {
      val r = Random.nextInt(size)
      val c = Random.nextInt(size)
      val avail = available(r, c).toIndexedSeq
      val numAvail = avail.size
      if (numAvail > 0) {
        val v = avail(Random.nextInt(numAvail))
        set(r, c, v)
      } else this 
    }
    num match {
      case 1 => setRandom
      case _ => setRandom.createRandom(num - 1)
    }
  }

  def solved = cells.forall(cell => cell.isSet)
  def unsolvable = options.isEmpty
  def solve: Pair[Boolean, Grid] =  {
    val p = Promise[(Boolean,Grid)]()
    val grids = (for(i <- 1 to size) yield deepCopy).toList
    for (g <- grids){
      Future(g.solve(0)) onComplete (p.tryComplete(_))
    }
    Await.result(p.future, Duration(2, MINUTES))
  }
  def deepCopy = {
    val copiedCells = for (c <- cells) yield new Cell(c.value, c.isGiven)
    new Grid(copiedCells)
  }
 
  def solve(index: Int): Pair[Boolean, Grid] = {
    if (solved) return (true, this) else if (unsolvable) return (false, this) else {
      val (row, col) = indexToRowCol(index)
      if (cell(row, col).isSet) return solve(index + 1) else {
        val iter = Random.shuffle(available(row, col).toList).iterator
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
  def parseFromString(string: String) = {

    val listChar = string.toList.filter(char => ('0' to '9').contains(char))
    var listInt = listChar.map(c => c.toString.toInt)
    var g = new Grid(sqrt(listInt.size).toInt)
    for (r <- 0 until this.size; c <- 0 until this.size) {
      val v = listInt.head
      g = g.set(r, c, v)
      listInt = listInt.drop(1)
    }
    g
  }
}
