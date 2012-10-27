package de.htwg.sudoku.model.fun
 
import org.specs2.mutable._

class CellSpec extends SpecificationWithJUnit {
  "A new Cell set to 0 " should {
    val cell = new Cell(0)
    
    "have value 0" in {
      cell.value must be_==(0)
    }
     
    "be not set" in {
      cell.isSet must beFalse
    }
    
    "not be given" in {
      cell.given must beFalse
    }

    "not show their Candidates" in {
      cell.showCandidates must beFalse
    }
    
    "generate a String of the form '.'" in {
      cell.toString must be_==(".")
    }

    "equal 0" in {
      (cell == 0) must beTrue
    }
  }
  
  "A new Cell set to 2 " should {
    val cell = new Cell(2)
    
    "have value 2" in {
      cell.value must be_==(2)
    }
     
    "be set" in {
      cell.isSet must beTrue
    }
    
    "not be given" in {
      cell.given must beFalse
    }

    "not show their Candidates" in {
      cell.showCandidates must beFalse
    }
    
    "generate a String of the form '2'" in {
      cell.toString must be_==("2")
    }

    "equal 0" in {
      (cell == 2) must beTrue
    }
  }
}