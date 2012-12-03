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

  // Match on Type
  
  val list = List(2, "three", Point(4,5))         //> list  : List[Any] = List(2, three, Point(4,5))
  list.foreach(item => item match {
  	case i:Int => println(i)
  	case s:String => println(s)
  	case p:Point => println(p)
  })                                              //> 2
                                                  //| three
                                                  //| Point(4,5)
  
  // Guarded match
  list.foreach(item => item match {
  	case i:Int if i > 0 => println("positive Int")
  	case j:Int if j < 0 => println("negative Int")
  	case z:Int if z == 0 => println("zero")
  	case s:String => println(s)
  	case p:Point => println(p)
  })                                              //> positive Int
                                                  //| three
                                                  //| Point(4,5)
  // Pattern Matching
  list match {
  	case h::t => println(h);println(t)
  }                                               //> 2
                                                  //| List(three, Point(4,5))
    
  // iSort using pattern matching
  def isort(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case head :: tail => insert(head, isort(tail))
  }                                               //> isort: (list: List[Int])List[Int]
  def insert(elem: Int, list: List[Int]): List[Int] = list match {
    case Nil => List(elem)
    case head :: tail => if (elem <= head) elem :: list
	else head :: insert(elem, tail)
  }                                               //> insert: (elem: Int, list: List[Int])List[Int]
  
  isort(List(8,3,5,1,2,9,4,6,7))                  //> res4: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  
  
 def roman(in: List[Char]): Int = in match {
   case 'I' :: 'V' :: rest => 4 + roman(rest)
   case 'I' :: 'X' :: rest => 9 + roman(rest)
   case 'I' :: rest => 1 + roman(rest)
   case 'V' :: rest => 5 + roman(rest)
   case 'X' :: 'L' :: rest => 40 + roman(rest)
   case 'X' :: 'C' :: rest => 90 + roman(rest)
   case 'X' :: rest => 10 + roman(rest)
   case 'L' :: rest => 50 + roman(rest)
   case 'C' :: 'D' :: rest => 400 + roman(rest)
   case 'C' :: 'M' :: rest => 900 + roman(rest)
   case 'C' :: rest => 100 + roman(rest)
   case 'D' :: rest => 500 + roman(rest)
   case 'M' :: rest => 1000 + roman(rest)
   case _ => 0
 }                                                //> roman: (in: List[Char])Int
  
  roman("MMXII".toList)                           //> res5: Int = 2012
  roman("MCMXCIX".toList)                         //> res6: Int = 1999
        
  // TODO
  // Write a parser for a command line tetris game
  // choose commands like j and k to move left and right.
  // print out the meaning of the command.

}