package de.htwg.sudoku.aview.swing

import scala.swing._
import scala.swing.event._
import de.htwg.sudoku.controller.SudokuController
import de.htwg.sudoku.controller.CellChanged

class CellPanel(row: Int, column: Int, controller: SudokuController) extends FlowPanel {

  val givenCellColor = new Color(200, 200, 255)
  val cellColor = new Color(224, 224, 255)
  val highlightedCellColor = new Color(192, 255, 192)
  
  def myCell = controller.cell(row, column)

  val cellButton = new Button {
    text = myCell.toString()
    font = new Font("Verdana", 1, 22)
    preferredSize = new Dimension(51, 51)
    opaque=true
    background = if (myCell.isGiven) givenCellColor else cellColor
  }
  contents += cellButton
  listenTo(cellButton)
  cellButton.text = myCell.toString()
  
  def redraw = {
    contents.clear()
    cellButton.text = myCell.toString()
    cellButton.background = if (myCell.isGiven) givenCellColor
      else if (myCell.isHighlighted) highlightedCellColor
      else cellColor
    if ((myCell.showCandidates || controller.showAllCandidates) && !myCell.isSet)  { 
      contents += candidatePanel
    } else {
      contents += cellButton
    }
    repaint
  }

  def candidatePanel = { 
    new GridPanel(controller.blockSize, controller.blockSize) {
      for (x <- 0 until controller.blockSize; y <- 1 to controller.blockSize) {
        val value = x * controller.blockSize + y
        val candidateButton = new Button {
          text = if (controller.available(row, column).contains(value)) value.toString else " "
          preferredSize = new Dimension(17, 17)
          margin = new Insets(0, 0, 0, 0)
          font = new Font("Verdana", 1, 9)
          background = cellColor
        }
        contents += candidateButton
        listenTo(candidateButton)
        reactions += {
          case ButtonClicked(source) =>
            controller.set(row, column, source.text.toInt)
            repaint
        }
      }
    }
  }

  reactions += {
    case ButtonClicked(source) =>
      myCell.showCandidates = true
      redraw
      publish(new CellChanged)
  }
}