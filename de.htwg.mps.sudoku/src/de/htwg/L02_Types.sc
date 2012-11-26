object L02_Types {
  // Data Types
  // Byte, Short, Int Long
  val abyte: Byte = 27 // 8 bit: range -128 to 127//> abyte  : Byte = 27
  val ashort: Short = 1024 // 16 bit: range -32,768 to 32,767
                                                  //> ashort  : Short = 1024
  val anInt = 17899 // 32 bit: Range -2,147,483,648 to 2,147,483,647
                                                  //> anInt  : Int = 17899
  val aLong: Long = 7587334 // 64 bit signed value. -9223372036854775808 to 9223372036854775807
                                                  //> aLong  : Long = 7587334
  // Float, Double
  val aDouble = 1.12345                           //> aDouble  : Double = 1.12345
  val aFloat = 1.2345f                            //> aFloat  : Float = 1.2345
  val tiny = 1.2345e-5                            //> tiny  : Double = 1.2345E-5
  val large = 9.87E45                             //> large  : Double = 9.87E45

  // Char, String
  val chr = 'A'                                   //> chr  : Char = A
  val chra = '\u0041' //Unicode for A             //> chra  : Char = A

  val helloW = "hello world"                      //> helloW  : java.lang.String = hello world
  val someEsc = "\\\"\'"                          //> someEsc  : java.lang.String = \"'

  // List
  val list: List[Int] = List(1, 2, 3, 4, 5)       //> list  : List[Int] = List(1, 2, 3, 4, 5)
  val listi = List(1, 2, 3, 4, 5)                 //> listi  : List[Int] = List(1, 2, 3, 4, 5)
  val lists = List("lines", "of", "actual", "information")
                                                  //> lists  : List[java.lang.String] = List(lines, of, actual, information)
  val empty:List[Int] = List()                    //> empty  : List[Int] = List()

  listi.head                                      //> res0: Int = 1
  listi.tail                                      //> res1: List[Int] = List(2, 3, 4, 5)
  1 :: 2 :: 3 :: Nil                              //> res2: List[Int] = List(1, 2, 3)

  // Array
  val array: Array[Int] = Array(1, 2, 3, 4, 5)    //> array  : Array[Int] = Array(1, 2, 3, 4, 5)
  val arrayi = Array(1, 2, 3, 4, 5)               //> arrayi  : Array[Int] = Array(1, 2, 3, 4, 5)
  val arrays = Array("lines", "of", "actual", "information")
                                                  //> arrays  : Array[java.lang.String] = Array(lines, of, actual, information)
  arrayi(1)                                       //> res3: Int = 2
  arrays(3)                                       //> res4: java.lang.String = information

  // Vector
  val vectori = Vector(1, 2, 3, 4, 5)             //> vectori  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 5)

  vectori(2)                                      //> res5: Int = 3
  vectori :+ 6 :+ 7                               //> res6: scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 5, 6, 7)
                                                  //| 
  vectori ++ Vector(6, 7)                         //> res7: scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 5, 6, 7)
                                                  //| 

  val vectormix = Vector(1, "one", 'I')           //> vectormix  : scala.collection.immutable.Vector[Any] = Vector(1, one, I)

  // Range
  val r1 = Range(1, 5)                            //> r1  : scala.collection.immutable.Range = Range(1, 2, 3, 4)
  val r2 = 1 to 5                                 //> r2  : scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5)
  val r3 = 1 until 6                              //> r3  : scala.collection.immutable.Range = Range(1, 2, 3, 4, 5)
  
  //Transformations
  vectori.toList                                  //> res8: List[Int] = List(1, 2, 3, 4, 5)
  r1.toList                                       //> res9: List[Int] = List(1, 2, 3, 4)
  r2.toArray                                      //> res10: Array[Int] = Array(1, 2, 3, 4, 5)
  r3.toIndexedSeq                                 //> res11: scala.collection.immutable.IndexedSeq[Int] = Range(1, 2, 3, 4, 5)
  
  // TODO Create a List that contains all primes between 1 and 25
  
  var sieve = (2 to 25).toList                    //> sieve  : List[Int] = List(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 1
                                                  //| 6, 17, 18, 19, 20, 21, 22, 23, 24, 25)
  for(i <- 2 to 25/2; j <- 2 to i) sieve = sieve - i*j
  sieve                                           //> res12: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23)
}