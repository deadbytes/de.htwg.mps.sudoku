package de.htwg.sudoku.aview.tui

import de.htwg.sudoku.model.Grid
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
    println("Enter command: q-Quit s-Solve n-New v-Validate e,m,h-easy/middle/hard r-Random .,+,#-SetSize x-Candidates xy-ReadCell xyz-SetCell")
  }
  def processInputLine(input: String) = {
    var continue = true
    input match {
      case "q" => continue = false
      case "s" => {
        val success = controller.solve;
        println(controller.statusText)
      }
      case "n" => controller.reset
      case "e" => controller.parseFromString(fromFile("resources/sudoku_easy.txt").mkString)
      case "m" => controller.parseFromString(fromFile("resources/sudoku_middle.txt").mkString)
      case "h" => controller.parseFromString(fromFile("resources/sudoku_hard.txt").mkString)
      case "r" => controller.createRandom
      case "v" => println("This Puzzle is " + (if (controller.valid) "" else "not") + " valid")
      case "." => controller.resize(1)
      case "+" => controller.resize(4)
      case "#" => controller.resize(9)
      case _ => {
        input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
          case row :: column :: value :: Nil => controller.set(row, column, value)
          case row :: column :: Nil => {
            controller.showCandidates(row, column)
            println("(" + row + ", " + column + ") = " + controller.cell(row, column).toString + " " + controller.available(row, column).toString)
          }
          case highlight :: Nil => controller.highlight(highlight)
          case _ => println("False Input!!!")
        }
      }
    }
    continue
  }
}