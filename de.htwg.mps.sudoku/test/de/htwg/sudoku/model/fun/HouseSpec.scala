package de.htwg.sudoku.model.fun

import org.specs2.mutable._

class HouseSpec extends SpecificationWithJUnit {

  "A new House with zero Cells" should {
    val house = new House(Vector())
    "be valid" in {
      house.valid must beTrue
    }
    "produce an empty String " in {
      house.toString must be_==("")
    }
  }

  "A new House with one empty Cell" should {
    val house = new House(Vector(new Cell(0)))
    "be valid" in {
      house.valid must beTrue
    }
    "produce an String ' '" in {
      house.toString must be_==(" ")
    }
  }

  "A new House with one filled Cell" should {
    val cell0 = new Cell(1)
    val house = new House(Vector(cell0))
    "be valid" in {
      house.valid must beTrue
    }
    "produce an String 1" in {
      house.toString must be_==("1")
    }
    "return its cells by index" in {
      house.cells(0) must be(cell0)
    }
  }

  "A House with two identical Cells" should {
    val cell0 = new Cell(1)
    val cell1 = new Cell(1)
    val house = new House(Vector(cell0, cell1))
    "be not valid" in {
      house.valid must beFalse
    }
    "return its cells by index" in {
      house.cells(0) must be(cell0)
      house.cells(1) must be(cell1)
    }
  }
  "A House with two different Cells" should {
    val cell0 = new Cell(1)
    val cell1 = new Cell(2)
    val house = new House(Vector(cell0, cell1))
    "be valid" in {
      house.valid must beTrue
    }
  }
  "A House with four empty cells" should {
    val house = new House(Vector.fill(4)(new Cell(0)))
    "be valid" in {
      house.toIntList must be_==(List())
      house.toIntSet.toList must be_==(List())
      house.valid must beTrue
    }
  }
  "A House with four different cells" should {
    val house = new House(Vector(new Cell(1), new Cell(2), new Cell(3), new Cell(4)))
    "be valid" in {
      house.valid must beTrue
    }
  }
}