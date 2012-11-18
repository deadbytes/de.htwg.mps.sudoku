object L01_Expressions {
  // Simple Expressions
  1 + 2                                           //> res0: Int(3) = 3
  3 + 4 * (2 - 3)                                 //> res1: Int = -1
  23 % 5                                          //> res2: Int(3) = 3
  3.5 * 9.4 + 6 / 4                               //> res3: Double = 33.9

  // Variables
  val width = 1024                                //> width  : Int = 1024
  var height = width * 9 / 16                     //> height  : Int = 576
  println(height)                                 //> 576

  //width = 1440
  height = width * 3 / 4
  height                                          //> res4: Int = 768

  var inc = 5                                     //> inc  : Int = 5
  inc += 5

  // Bit operations
  3 & 2 // logical and                            //> res5: Int(2) = 2
  1 | 2 // logical or                             //> res6: Int(3) = 3
  1 ^ 2 // logical xor                            //> res7: Int(3) = 3
  1 << 2 // shift left                            //> res8: Int(4) = 4

  // Boolean operations
  true                                            //> res9: Boolean(true) = true
  false                                           //> res10: Boolean(false) = false
  1 > 2 // greater than                           //> res11: Boolean(false) = false
  1 < 2 // less than                              //> res12: Boolean(true) = true
  1 == 2 // equals                                //> res13: Boolean(false) = false
  1 >= 2 // greater than or equal                 //> res14: Boolean(false) = false
  1 != 2 // less than or equal                    //> res15: Boolean(true) = true
  true || false // or                             //> res16: Boolean(true) = true
  true && false // and                            //> res17: Boolean(false) = false

  // If-Expression
  if (1 > 2) 4 else 5 // greater than             //> res18: Int = 5
  if (1 < 2) 6 else 7 // less than                //> res19: Int = 6
  if (width == 1024 && height == 576) "PAL"       //> res20: Any = ()
  if (width / height == 16 / 9) "PAL"             //> res21: Any = PAL
  val resolution = if (width / height == 16 / 9) "PAL"
                                                  //> resolution  : Any = PAL

  // Loops
  var total1 = 18                                 //> total1  : Int = 18
  while (total1 < 17) total1 += 3
  total1                                          //> res22: Int = 18

  var total2 = 18                                 //> total2  : Int = 18
  do {
    total2 += 3
  } while (total2 < 17)
  total2                                          //> res23: Int = 21

  // find the greatest common divisor
  var x = 36                                      //> x  : Int = 36
  var y = 99                                      //> y  : Int = 99
  while (x != 0) {
    val temp = x
    x = y % x
    y = temp
  }
  println("gcd is" + y)                           //> gcd is9

  // For-Expression
  for (i <- 1 to 4) println("hi five")            //> hi five
                                                  //| hi five
                                                  //| hi five
                                                  //| hi five
  for (i <- 1 until 4) println(i)                 //> 1
                                                  //| 2
                                                  //| 3
  for (i <- 1 until 4; j <- 1 to 3) println(i, j) //> (1,1)
                                                  //| (1,2)
                                                  //| (1,3)
                                                  //| (2,1)
                                                  //| (2,2)
                                                  //| (2,3)
                                                  //| (3,1)
                                                  //| (3,2)
                                                  //| (3,3)
  for (c <- "hello") println(c)                   //> h
                                                  //| e
                                                  //| l
                                                  //| l
                                                  //| o


}