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

}