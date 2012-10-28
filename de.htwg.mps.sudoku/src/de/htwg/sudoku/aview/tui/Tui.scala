package de.htwg.sudoku.aview.tui

import de.htwg.sudoku.model.fun.Grid
import de.htwg.sudoku.controller.SudokuController
import de.htwg.sudoku.controller.CellChanged
import de.htwg.sudoku.controller.GridSizeChanged
import de.htwg.util.Observable
import de.htwg.util.Observer
import scala.io.Source._
import swing._

class Tui(var controller: SudokuController) extends Reactor {
  listenTo(controller)
  printTui
    reactions += {
    case e: GridSizeChanged => printTui
    case e: CellChanged => printTui
  }
  def update = printTui
  def printTui = {
    println(controller.grid.toString)
    println("Enter command: q-Quit s-Solve n-New v-Validate e,m,h-Load easy middle or hard, r-Random 1,4,9-Set Size, xy-Read Cell, xyz-Set Cell")
  }
  def processInputLine(input: String) = {
    var continue = true
    input match {
      case "q" => continue = false
      case "s" => {
        var (success, steps) = controller.solve;
        if (success) println("Puzzle solved in " + steps + " steps") else println("This puzzle could not be solved!")
      }
      case "n" => controller.reset
      case "e" => controller.parseFromString(fromFile("resources/sudoku_easy.txt").mkString)
      case "m" => controller.parseFromString(fromFile("resources/sudoku_middle.txt").mkString)
      case "h" => controller.parseFromString(fromFile("resources/sudoku_hard.txt").mkString)
      case "r" => controller.createRandom
      case "v" => println("This Puzzle is " + (if (controller.valid) "" else "not") + " valid")
      case "1" => controller.resize(1)
      case "4" => controller.resize(4)
      case "9" => controller.resize(9)
      case _ => {
        input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
          case row :: column :: value :: Nil => {
            controller.set(row, column, value)
          }
          case row :: column :: Nil => {
            println("(" + row + ", " + column + ") = " + controller.cell(row, column).toString + " " + controller.available(row, column).toString)
          }
          case _ => println("False Input!!!")
        }
      }
    }
    continue
  }
}