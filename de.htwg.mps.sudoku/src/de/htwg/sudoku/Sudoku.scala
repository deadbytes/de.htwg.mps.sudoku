package de.htwg.sudoku


import de.htwg.sudoku.model.fun.Grid
import de.htwg.sudoku.aview.tui.Tui

object Sudoku {

  def main(args: Array[String]) {

    var grid = new Grid(9)
    new Tui(grid).parse

  }
}