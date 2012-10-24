package de.htwg.sudoku


import de.htwg.sudoku.fun.entities.Grid
import de.htwg.sudoku.tui.Tui

object Sudoku {

  def main(args: Array[String]) {

    var grid = new Grid(9)
    new Tui(grid).parse

  }
}