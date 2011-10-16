package de.htwg.sudoku.entities

object Sudoku {

  def main(args: Array[String]) {
    var grid = new Grid(9)
    println(grid.toString)
    grid.solve
    println(grid.toString)
  }
}