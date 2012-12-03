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
    val x = ix
    val y = iy
  }

  val p2 = new Point2(3, 4)                       //> p2  : L04_Classes.Point2 = L04_Classes$$anonfun$main$1$Point2$1@20c1f10e
  
   // Parameter as public fields
  class Point3(val x: Int, val y: Int)
  
  // Default parameter
  class Point3D(val x:Int, val y:Int, z:Int=0)
  
  val p3d1 = new Point3D(4,7,3)                   //> p3d1  : L04_Classes.Point3D = L04_Classes$$anonfun$main$1$Point3D$2@2d342ba4
                                                  //| 
  val p3d2 = new Point3D(4,7)                     //> p3d2  : L04_Classes.Point3D = L04_Classes$$anonfun$main$1$Point3D$2@210a6ae2
                                                  //| 
  
  // Named parameter
  class PointN(val row:Int, val col:Int)
  
  val pn1 = new PointN(row =5, col =8)            //> pn1  : L04_Classes.PointN = L04_Classes$$anonfun$main$1$PointN$1@744a6cbf
  println("row = " +pn1.row)                      //> row = 5
  val pn2 = new PointN(col = 8, row = 5)          //> pn2  : L04_Classes.PointN = L04_Classes$$anonfun$main$1$PointN$1@4229ab3e
  println("row = " +pn2.row)                      //> row = 5
  
  // Methods for Classes
  class Point4(val x: Int, val y: Int) {
    def vectorAdd(newpt: Point4): Point4 = {
      new Point4(x + newpt.x, y + newpt.y)
    }
  }

  val p31 = new Point4(3, 4)                      //> p31  : L04_Classes.Point4 = L04_Classes$$anonfun$main$1$Point4$1@488e32e7
  val p32 = new Point4(7, 2)                      //> p32  : L04_Classes.Point4 = L04_Classes$$anonfun$main$1$Point4$1@6fb000e7
  val p33 = p31.vectorAdd(p32)                    //> p33  : L04_Classes.Point4 = L04_Classes$$anonfun$main$1$Point4$1@c0b76fa
  println(p33.x, p33.y)                           //> (10,6)

  // Methods with more flexible names
  class Point5(val x: Int, val y: Int) {
    def +(newpt: Point5): Point5 = {
      new Point5(x + newpt.x, y + newpt.y)
    }
    def -(newpt: Point5): Point5 = {
      new Point5(x - newpt.x, y - newpt.y)
    }
    override def toString = "Point5(" + x + "," + y + ")"
  }
  val p41 = new Point5(3, 4)                      //> p41  : L04_Classes.Point5 = Point5(3,4)
  val p42 = new Point5(7, 2)                      //> p42  : L04_Classes.Point5 = Point5(7,2)
  val p43 = new Point5(-2, 2)                     //> p43  : L04_Classes.Point5 = Point5(-2,2)
  val p44 = p41.+(p42).-(p43)                     //> p44  : L04_Classes.Point5 = Point5(12,4)
  println(p44)                                    //> Point5(12,4)

  // infix notation
  class Point6(val x: Int, val y: Int) {
    def +(newpt: Point6) = new Point6(x + newpt.x, y + newpt.y)
    def -(newpt: Point6) = new Point6(x - newpt.x, y - newpt.y)
    override def toString = "Point6(" + x + "," + y + ")"
  }
  val p51 = new Point6(3, 4)                      //> p51  : L04_Classes.Point6 = Point6(3,4)
  val p52 = new Point6(7, 2)                      //> p52  : L04_Classes.Point6 = Point6(7,2)
  val p53 = new Point6(-2, 2)                     //> p53  : L04_Classes.Point6 = Point6(-2,2)
  p51 + p52 - p53                                 //> res2: L04_Classes.Point6 = Point6(12,4)

  // Case Class
  case class Point7(x: Int, y: Int) {
    def +(newpt: Point7) = Point7(x + newpt.x, y + newpt.y)
    def -(newpt: Point7) = Point7(x - newpt.x, y - newpt.y)
    override def toString = "Point7(" + x + "," + y + ")"
  }
  val p61 = Point7(3, 4)                          //> p61  : L04_Classes.Point7 = Point7(3,4)
  val p62 = Point7(7, 2)                          //> p62  : L04_Classes.Point7 = Point7(7,2)
  val p63 = Point7(-2, 2)                         //> p63  : L04_Classes.Point7 = Point7(-2,2)
  p61 + p62 - p63                                 //> res3: L04_Classes.Point7 = Point7(12,4)
 
// TODO write a class for screen resolutions
// It should contain the width, the hight and a name of a resolution
// It should have a method to compute the number of pixels
// It should have a method to compare the size of two resolutions
 
}