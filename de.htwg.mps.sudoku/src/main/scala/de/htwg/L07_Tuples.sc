object L07_Tuples {
  1+2                                             //> res0: Int(3) = 3
  //Tuples
  class IntStringPair(val int: Int, val string: String)

  val pair1 = new IntStringPair(78462, "Konstanz")//> pair1  : L07_Tuples.IntStringPair = L07_Tuples$$anonfun$main$1$IntStringPair
                                                  //| $1@29e97f9f
  val int = pair1.int                             //> int  : Int = 78462
  val string = pair1.string                       //> string  : String = Konstanz

  class Pair(val _1: Any, val _2: Any)

  val pair2 = new Pair(78462, "Konstanz")         //> pair2  : L07_Tuples.Pair = L07_Tuples$$anonfun$main$1$Pair$1@939b78e
  val first = pair2._1                            //> first  : Any = 78462
  val second = pair2._2                           //> second  : Any = Konstanz

  val pair3 = new Tuple2(78462, "Konstanz")       //> pair3  : (Int, java.lang.String) = (78462,Konstanz)
  val tuple_1 = pair3._1                          //> tuple_1  : Int = 78462
  val tuple_2 = pair3._2                          //> tuple_2  : java.lang.String = Konstanz

  val triple1 = new Tuple3(78462, "Konstanz", "DE")
                                                  //> triple1  : (Int, java.lang.String, java.lang.String) = (78462,Konstanz,DE)
  val triple1_3 = triple1._3                      //> triple1_3  : java.lang.String = DE

  val pair4 = ("hello", 5)                        //> pair4  : (java.lang.String, Int) = (hello,5)
  val tripple4 = (78462, "Konstanz", "DE")        //> tripple4  : (Int, java.lang.String, java.lang.String) = (78462,Konstanz,DE)

  class Key(val key: Int) {
    def ->(value: String) = new Pair(key, value)
  }

  val zip = new Key(78462)                        //> zip  : L07_Tuples.Key = L07_Tuples$$anonfun$main$1$Key$1@ac980c9
  val city = "Konstanz"                           //> city  : java.lang.String = Konstanz
  val pair5 = zip -> city                         //> pair5  : L07_Tuples.Pair = L07_Tuples$$anonfun$main$1$Pair$1@332611a7
  pair5._1                                        //> res1: Any = 78462
  pair5._2                                        //> res2: Any = Konstanz

  val pair6 = 78462 -> "Konstanz"                 //> pair6  : (Int, java.lang.String) = (78462,Konstanz)

  val (key, value) = 78462 -> "Konstanz"          //> key  : Int = 78462
                                                  //| value  : java.lang.String = Konstanz
  key                                             //> res3: Int = 78462
  value                                           //> res4: java.lang.String = Konstanz

  val list = for (i <- 1 to 5) yield i            //> list  : scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 3, 4, 5)
}