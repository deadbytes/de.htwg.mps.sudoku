package de.htwg.sudoku.tui

import de.htwg.sudoku.fun.entities.Grid
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
        case "s" => grid=grid.solve
        case "n" => grid=grid.reset
//        case "e" => grid.parseFromString(fromFile("resources/sudoku_easy.txt").mkString)
//        case "m" => grid.parseFromString(fromFile("resources/sudoku_middle.txt").mkString)
//        case "h" => grid.parseFromString(fromFile("resources/sudoku_hard.txt").mkString)
        case "r" => grid= grid.createRandom(30)
        case "1" => grid = new Grid(1)
        case "4" => grid = new Grid(4)
        case "9" => grid = new Grid(9)
        case _ => {
          input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
            case row :: column :: value :: Nil => {
              grid=grid.set(row, column,value)
            }
            case row :: column :: Nil => {
              println("("+row+", "+column+") = "+grid.cell(row, column).toString + " " + grid.available(row, column).toString)
            }
            case _ => println("False Input!!!")
          }
        }
      }
    }
  }

}