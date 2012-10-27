package de.htwg.sudoku.controller

import de.htwg.util.Observable
import de.htwg.sudoku.model.fun.Grid

class SudokuController(var grid: Grid) extends Observable {
  def available(row: Int, col: Int) = grid.available(row, col)
  def cell(row: Int, col: Int) = grid.cell(row, col)
  def reset = {
    grid = grid.reset
    notifyObservers
  }
  def resize(newSize: Int) = {
    grid = new Grid(newSize)
    notifyObservers
  }
  def set(row: Int, col: Int, value: Int) = {
    grid = grid.set(row, col, value)
    notifyObservers
  }
  def solve = {
    val (success, g) = grid.solve
    grid = g  
    notifyObservers
    (success, Grid.steps)
  }

}