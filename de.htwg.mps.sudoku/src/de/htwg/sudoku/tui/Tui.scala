package de.htwg.sudoku.tui

import de.htwg.sudoku.entities.Grid
import scala.io.Source._

class Tui(var grid: Grid) {
  var input = ""

  def parse = {
    var continue=true
    while (continue) {
      println(grid.toString)
      println("Enter command: q-Quit s-Solve n-New e,m,h-Load easy middle or hard, r-Random 1,4,9-Set Size, xy-Read Cell, xyz-Set Cell")
      input = readLine()
      input match {
        case "q" => continue=false
        case "s" => grid.solve
        case "n" => grid.reset
        case "e" => grid.parseFromString(fromFile("resources/sudoku_easy.txt").mkString)
        case "m" => grid.parseFromString(fromFile("resources/sudoku_middle.txt").mkString)
        case "h" => grid.parseFromString(fromFile("resources/sudoku_hard.txt").mkString)
        case "r" => grid.createRandom(30)
        case "1" => grid = new Grid(1)
        case "4" => grid = new Grid(4)
        case "9" => grid = new Grid(9)
        case _ => {
          input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
            case row :: column :: value :: Nil => {
              grid.cell(row, column) := value
            }
            case row :: column :: Nil => {
              println(grid.cell(row, column).mkString + " " + grid.candidateSet(row, column).toString)
            }
            case _ => println("False Input!!!")
          }
        }
      }
    }
  }

}