package de.htwg.sudoku.aview.swing

import scala.swing._
import javax.swing.table._
import scala.swing.event._
import de.htwg.sudoku.controller.SudokuController
import de.htwg.sudoku.controller.CellChanged

class CellPanel(row: Int, column: Int, controller: SudokuController) extends FlowPanel {

  val givenCellColor = new Color(200, 200, 255)
  val cellColor = new Color(224, 224, 255)
  val highlightedCellColor = new Color(192, 255, 192)

  def myCell = controller.cell(row, column)

  val label =
    new Label {
      text = " " + myCell.toString
      font = new Font("Verdana", 1, 36)
    }

  val cell = new BoxPanel(Orientation.Vertical) {
    contents += label
    preferredSize = new Dimension(51, 51)
    background = if (myCell.isGiven) givenCellColor else cellColor
    border = Swing.BeveledBorder(Swing.Raised)
    listenTo(mouse.clicks)
    listenTo(controller)
    reactions += {
      case e: CellChanged => {
        label.text = " " + myCell.toString
        repaint
      }
      case MouseClicked(src, pt, mod, clicks, pops) => {
        controller.showCandidates(row, column)
        repaint
      }
    }
  }

  val candidatelist = (1 to controller.gridSize).map {
    (value =>
      new Label {
        text = if (controller.available(row, column).contains(value)) value.toString else " "
        preferredSize = new Dimension(17, 17)
        font = new Font("Verdana", 1, 9)
        background = cellColor
        border = Swing.BeveledBorder(Swing.Raised)
        listenTo(mouse.clicks)
        listenTo(controller)
        reactions += {
          case e: CellChanged => {
            text = if (controller.available(row, column).contains(value)) value.toString else " "
            repaint
          }
          case MouseClicked(src, pt, mod, clicks, pops) => {
            controller.set(row, column, value)
            text = if (controller.available(row, column).contains(value)) value.toString else " "
            repaint
          }
        }
      })
  }
  val candidates = new GridPanel(controller.blockSize, controller.blockSize) {
    setBackground(this)
    contents ++= candidatelist
  }
  contents += candidates

  def redraw = {
    contents.clear()
    if ((myCell.isShowingCandidates || controller.showAllCandidates) && !myCell.isSet) {
      setBackground(candidates)
      contents += candidates
    } else {
      label.text = " " + myCell.toString()
      setBackground(cell)
      contents += cell
    }
    repaint
  }

  def setBackground(p: Panel) = p.background = if (myCell.isGiven) givenCellColor
  else if (myCell.isHighlighted) highlightedCellColor
  else cellColor

}