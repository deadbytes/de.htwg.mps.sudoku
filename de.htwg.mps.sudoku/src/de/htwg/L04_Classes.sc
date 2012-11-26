object L04_Classes {
1+2                                               //> res0: Int(3) = 3
2+3                                               //> res1: Int(5) = 5
  //Classes
  class Point1 {
    var x = 0
    var y = 0
  }

  val p1 = new Point1                             //> p1  : L04_Classes.Point1 = L04_Classes$$anonfun$main$1$Point1$1@29e97f9f
  p1.x = 3
  p1.y = 4

  println(p1.x, p1.y)                             //> (3,4)
  
   // Parameter for Classes
  class Point2(ix: Int, iy: Int) {
    var x = ix
    var y = iy
  }

  val p2 = new Point2(3, 4)                       //> p2  : L04_Classes.Point2 = L04_Classes$$anonfun$main$1$Point2$1@20c1f10e
  // Methods for Classes
  class Point3(ix: Int, iy: Int) {
    var x = ix
    var y = iy
    def vectorAdd(newpt: Point3): Point3 = {
      new Point3(x + newpt.x, y + newpt.y)
    }
  }

  val p31 = new Point3(3, 4)                      //> p31  : L04_Classes.Point3 = L04_Classes$$anonfun$main$1$Point3$1@2d342ba4
  val p32 = new Point3(7, 2)                      //> p32  : L04_Classes.Point3 = L04_Classes$$anonfun$main$1$Point3$1@3c1d332b
  val p33 = p31.vectorAdd(p32)                    //> p33  : L04_Classes.Point3 = L04_Classes$$anonfun$main$1$Point3$1@210a6ae2
  println(p33.x, p33.y)                           //> (10,6)

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
  val p41 = new Point4(3, 4)                      //> p41  : L04_Classes.Point4 = Point4(3,4)
  val p42 = new Point4(7, 2)                      //> p42  : L04_Classes.Point4 = Point4(7,2)
  val p43 = new Point4(-2, 2)                     //> p43  : L04_Classes.Point4 = Point4(-2,2)
  val p44 = p41 + p42 - p43                       //> p44  : L04_Classes.Point4 = Point4(12,4)
  println(p44.x, p44.y)                           //> (12,4)

  // Parameter as public fields
  class Point5(val x: Int, val y: Int) {
    def +(newpt: Point5) = new Point5(x + newpt.x, y + newpt.y)
    def -(newpt: Point5) = new Point5(x - newpt.x, y - newpt.y)
    override def toString = "Point5(" + x + "," + y + ")"
  }
  val p51 = new Point5(3, 4)                      //> p51  : L04_Classes.Point5 = Point5(3,4)
  val p52 = new Point5(7, 2)                      //> p52  : L04_Classes.Point5 = Point5(7,2)
  val p53 = new Point5(-2, 2)                     //> p53  : L04_Classes.Point5 = Point5(-2,2)
  p51 + p52 - p53                                 //> res2: L04_Classes.Point5 = Point5(12,4)

  // Case Class
  case class Point6(x: Int, y: Int) {
    def +(newpt: Point6) = Point6(x + newpt.x, y + newpt.y)
    def -(newpt: Point6) = Point6(x - newpt.x, y - newpt.y)
    override def toString = "Point6(" + x + "," + y + ")"
  }
  val p61 = Point6(3, 4)                          //> p61  : L04_Classes.Point6 = Point6(3,4)
  val p62 = Point6(7, 2)                          //> p62  : L04_Classes.Point6 = Point6(7,2)
  val p63 = Point6(-2, 2)                         //> p63  : L04_Classes.Point6 = Point6(-2,2)
  p61 + p62 - p63                                 //> res3: L04_Classes.Point6 = Point6(12,4)
 

}