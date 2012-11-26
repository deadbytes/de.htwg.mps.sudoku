package de.htwg.sudoku.controller

import de.htwg.util.Observable
import de.htwg.sudoku.model.fun.Grid
import scala.swing.event.Event
import scala.swing.Publisher

case class CellChanged extends Event 
case class GridSizeChanged(newSize:Int) extends Event

class SudokuController(var grid: Grid) extends Publisher {
  var statusText="Sudoku"
  def blockSize = grid.blocknum
  def gridSize= grid.size
  def available(row: Int, col: Int) = grid.available(row, col)
  def cell(row: Int, col: Int) = grid.cell(row, col)
  def highlight(index:Int) = {
    grid.highlight(index) 
    publish(new CellChanged)
  }
    
  def createRandom={
    grid = grid.createRandom(grid.size)
    grid.setGiven
    statusText="Created new Sudoku with "+grid.size+" random cells"
    publish(new CellChanged)
  }
  def parseFromString(s:String) = {
    grid = grid.parseFromString(s)
    statusText="Read Sudoku from file"
    publish(new CellChanged)
  }
  def reset = {
    grid = grid.reset
    statusText="Sudoku was reset"
    publish(new CellChanged)
  }
  def resize(newSize: Int) = {
    grid = new Grid(newSize)
    statusText="New Sudoku of size "+newSize
    publish(new GridSizeChanged(newSize))
  }
  def set(row: Int, col: Int, value: Int) = {
    grid = grid.set(row, col, value)
    statusText="Set Cell ("+ row+","+col+") to "+value
    publish(new CellChanged)
  }
  def showCandidates(row:Int, column:Int) ={
    cell(row, column).showCandidates
    statusText = "(" + row + ", " + column + ") = " + cell(row, column).toString + " " + available(row, column).toString
    publish(new CellChanged)
  }
  def solve = {
    val (success, g) = grid.solve
    grid = g  
    statusText = if(success) "Solved Sudoku in "+ Grid.steps +" steps" else "Sudoku can not be solved"
    publish(new CellChanged)
    (success, Grid.steps)
  }
  def valid = grid.valid
  def showAllCandidates=false
}