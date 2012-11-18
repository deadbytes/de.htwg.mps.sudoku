object L05_Match {
  // Match as Statement on Int
  def decode1(n: Int) = {
    n match {
      case 1 => println("One")
      case 2 => println("Two")
      case 5 => println("Five")
      case _ => println("Error")
    }
  }                                               //> decode1: (n: Int)Unit
  decode1(2)                                      //> Two
  
  // Match as Expression on Int
  def decode2(n: Int) = {
    println(n match {
      case 1 => "One"
      case 2 => "Two"
      case 5 => "Five"
      case _ => "Error"
    })
  }                                               //> decode2: (n: Int)Unit
  decode2(2)                                      //> Two

  // Match on String
  def encode(s: String) ={
    println(s match {
      case "One" => 1
      case "Two" => 2
      case "Five" => 5
      case _ => 0
    })
  }                                               //> encode: (s: String)Unit
  encode("Five")                                  //> 5
  
    case class Point(x: Int, y: Int) {
    def +(newpt: Point) = Point(x + newpt.x, y + newpt.y)
    def -(newpt: Point) = Point(x - newpt.x, y - newpt.y)
    override def toString = "Point(" + x + "," + y + ")"
  }

  // Match on Case Class
  def investigate(p:Point)= {p match {
   case Point(0,0) => "Origin"
   case Point(1,_) => "On line x=1"
   case Point(x,y) if (x>0 && y>0) => "Positive Quadrant"
   case _ => "Somewhere else"
   }
  }                                               //> investigate: (p: L05_Match.Point)java.lang.String
  
  investigate(Point(0,0))                         //> res0: java.lang.String = Origin
  investigate(Point(1,1))                         //> res1: java.lang.String = On line x=1
  investigate(Point(12,15))                       //> res2: java.lang.String = Positive Quadrant
  investigate(Point(-4,-3))                       //> res3: java.lang.String = Somewhere else
}