package de.htwg.sudoku

import de.htwg.sudoku.model.fun.Grid
import de.htwg.sudoku.controller.SudokuController
import de.htwg.sudoku.aview.tui.Tui
import de.htwg.sudoku.aview.swing.SwingGui

object Sudoku {
  val controller = new SudokuController(new Grid(9))
  val tui = new Tui(controller)
  val gui = new SwingGui(controller)

  def main(args: Array[String]) {

    while (tui.processInputLine(readLine())) {}
  }

}