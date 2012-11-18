object L04_Classes {
  //Classes
  class Point1 {
    var x = 0
    var y = 0
  }

  val p1 = new Point1

  p1.x = 3
  p1.y = 4

  println(p1.x, p1.y)
  
  
  // Parameter for Classes
  class Point2(ix: Int, iy: Int) {
    var x = ix
    var y = iy
  }

  val p2 = new Point2(3, 4)
  // Methods for Classes
  class Point3(ix: Int, iy: Int) {
    var x = ix
    var y = iy
    def vectorAdd(newpt: Point3): Point3 = {
      new Point3(x + newpt.x, y + newpt.y)
    }
  }

  val p31 = new Point3(3, 4)
  val p32 = new Point3(7, 2)
  val p33 = p31.vectorAdd(p32)
  println(p33.x, p33.y)

  // Methods with more flexible names
  class Point4(ix: Int, iy: Int) {
    var x = ix
    var y = iy
    def +(newpt: Point4): Point4 = {
      new Point4(x + newpt.x, y + newpt.y)
    }
    def -(newpt: Point4): Point4 = {
      new Point4(x - newpt.x, y - newpt.y)
    }
    override def toString = "Point4(" + x + "," + y + ")"
  }
  val p41 = new Point4(3, 4)
  val p42 = new Point4(7, 2)
  val p43 = new Point4(-2, 2)
  val p44 = p41 + p42 - p43
  println(p44.x, p44.y)

  // Parameter as public fields
  class Point5(val x: Int, val y: Int) {
    def +(newpt: Point5) = new Point5(x + newpt.x, y + newpt.y)
    def -(newpt: Point5) = new Point5(x - newpt.x, y - newpt.y)
    override def toString = "Point5(" + x + "," + y + ")"
  }
  val p51 = new Point5(3, 4)
  val p52 = new Point5(7, 2)
  val p53 = new Point5(-2, 2)
  p51 + p52 - p53

  // Case Class
  case class Point6(x: Int, y: Int) {
    def +(newpt: Point6) = Point6(x + newpt.x, y + newpt.y)
    def -(newpt: Point6) = Point6(x - newpt.x, y - newpt.y)
    override def toString = "Point6(" + x + "," + y + ")"
  }
  val p61 = Point6(3, 4)
  val p62 = Point6(7, 2)
  val p63 = Point6(-2, 2)
  p61 + p62 - p63

}