package de.htwg.sudoku.model.fun

import org.specs2.mutable._

class GridSpec extends SpecificationWithJUnit {

  "A new Grid with 1 empty Cell" should {
    val cell0 = new Cell(0)
    val grid1 = new Grid(Vector(cell0))
    "return that cell" in {
      grid1.cell(0, 0) must be(cell0)
    }
    "be valid" in {
      grid1.valid must beTrue
    }
    "be not solved" in {
      grid1.solved must beFalse
    }
    "be not unsolvable" in {
      grid1.unsolvable must beFalse
    }
    "solve" in {
      grid1.solve._1 must beTrue
      grid1.solve._2.cell(0, 0).value must be_==(1)
    }
    "be filled completely by createRandom" in {
      grid1.createRandom(1).solved must beTrue
    }
    "generate a String of the form\n" +
      "+---+\n" +
      "|   |\n" +
      "+---+\n" in {
        grid1.toString must be_==("\n+---+\n|   |\n+---+\n")
      }
    "highlight its cell" in {
      cell0.highlighted must beFalse
      grid1.highlight(1)
      cell0.highlighted must beTrue
    }
  }
  "A new Grid with 1 filled Cell" should {
    val cell0 = new Cell(1)
    val grid1 = new Grid(Vector(cell0))
    "return that cell" in {
      grid1.cell(0, 0) must be(cell0)
    }
    "be valid" in {
      grid1.allrows.forall(_.valid) must beTrue
      grid1.allcols.forall(_.valid) must beTrue
      grid1.allblocks.forall(_.valid) must beTrue
      grid1.valid must beTrue
    }
    "be solved" in {
      grid1.solved must beTrue
    }
    "solve" in {
      grid1.solve._1 must beTrue
      grid1.solve._2.cell(0, 0).value must be_==(1)
    }
    "be filled completely by setRandom" in {
      grid1.createRandom(1).solved must beTrue
    }
    "generate a String of the form\n" +
      "+---+\n" +
      "| 1 |\n" +
      "+---+\n" in {
        grid1.toString must be_==("\n+---+\n| 1 |\n+---+\n")
      }
  }
  "A grid filled from the String 1 " should {
    val grid1 = new Grid(1).parseFromString("1")
    "have cell(0,0) hold value 1" in {
      grid1.cell(0, 0).value must be_==(1)
    }
    "if unset hold value 0 " in {
      grid1.unset(0, 0).cell(0, 0).value must be_==(0)
    }
    "if reset hold value 0" in {
      grid1.reset.cell(0, 0).value must be_==(0)
    }
  }
  "An empty grid of size 4" should {
    val grid4 = new Grid(4)
    "have size 4" in {
      grid4.size must be_==(4)
    }
    "be valid" in {
      grid4.rows(0).valid must beTrue
      grid4.rows(1).valid must beTrue
      grid4.rows(2).valid must beTrue
      grid4.rows(3).valid must beTrue
      grid4.allrows.forall(_.valid) must beTrue
      grid4.allcols.forall(_.valid) must beTrue
      grid4.allblocks.forall(_.valid) must beTrue
      grid4.valid must beTrue
    }
    "be not be solved" in {
      grid4.solved must beFalse
    }
    "have 4 rows, columns, and blocks" in {
      grid4.allrows.size must be_==(4)
      grid4.allcols.size must be_==(4)
      grid4.allblocks.size must be_==(4)

    }
    "solve" in {
      grid4.solve._2.solved must beTrue
    }
    "solve with Cells created by Random" in {
      grid4.createRandom(4).solve._2.solved must beTrue
    }
  }
  "A Grid with Cells that require backtracking to solve" should {
     var reqBacktrack = new Grid(4).set(0,0,4).set(0,1,3).set(0,2,2).set(0,3,1).set(1,0,2).set(1,1,1).set(1,3,4).set(3,3,3)
     "solve" in {
       reqBacktrack.solve._2.solved must beTrue
     }
  }  


}