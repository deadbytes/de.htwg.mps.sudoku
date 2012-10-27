package de.htwg.sudoku.aview.tui

import de.htwg.sudoku.model.fun.Grid
import scala.io.Source._

class Tui(var grid: Grid) {
  var input = ""

  def parse = {
    var continue = true
    while (continue) {
      println(grid.toString)
      println("Enter command: q-Quit s-Solve n-New v-Validate e,m,h-Load easy middle or hard, r-Random 1,4,9-Set Size, xy-Read Cell, xyz-Set Cell")
      input = readLine()
      input match {
        case "q" => continue = false
        case "s" => {
          var (success, g) = grid.solve;
          grid = g
          if (success) println("Puzzle solved in "+Grid.steps+" steps") else println("This puzzle could not be solved!")
        }
        case "n" => grid = grid.reset
        case "e" => grid = grid.parseFromString(fromFile("resources/sudoku_easy.txt").mkString)
        case "m" => grid = grid.parseFromString(fromFile("resources/sudoku_middle.txt").mkString)
        case "h" => grid = grid.parseFromString(fromFile("resources/sudoku_hard.txt").mkString)
        case "r" => grid = grid.createRandom(grid.size)
        case "v" => println("This Puzzle is "+ (if (grid.valid) "" else "not" )+" valid")
        case "1" => grid = new Grid(1)
        case "4" => grid = new Grid(4)
        case "9" => grid = new Grid(9)
        case _ => {
          input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
            case row :: column :: value :: Nil => {
              grid = grid.set(row, column, value)
            }
            case row :: column :: Nil => {
              println("(" + row + ", " + column + ") = " + grid.cell(row, column).toString + " " + grid.available(row, column).toString)
            }
            case _ => println("False Input!!!")
          }
        }
      }
    }
  }

}