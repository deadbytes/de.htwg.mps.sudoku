object L01_Expressions {
  // Simple Expressions
  1 + 2                                           //> res0: Int(3) = 3
  3 + 4 * (2 - 3)                                 //> res1: Int = -1
  23 % 5                                          //> res2: Int(3) = 3
  3.5 * 9.4 + 6 / 4                               //> res3: Double = 33.9
  
  // Simple String operations
  "Hello " + "World"                              //> res4: java.lang.String("Hello World") = Hello World
  println("Hello " + "World")                     //> Hello World

  // Variables
  val width = 1024                                //> width  : Int = 1024
  var height = width * 9 / 16                     //> height  : Int = 576
  println(height)                                 //> 576

  //width = 1440  //reassignment on val is not allowed
  height = width * 3 / 4
  height                                          //> res5: Int = 768

  var inc = 5                                     //> inc  : Int = 5
  inc += 5
  
  val name ="Marko"                               //> name  : java.lang.String = Marko
  val message = "Hello " + name                   //> message  : java.lang.String = Hello Marko
  println(message)                                //> Hello Marko
  
  // TODO Calculate the width of a HD 1080 resolution
  // It has a hight of 1080 and a ratio of 16:9
  val width_HD1080 = 1080*16/9                    //> width_HD1080  : Int = 1920

  // Bit operations
  3 & 2 // logical and                            //> res6: Int(2) = 2
  1 | 2 // logical or                             //> res7: Int(3) = 3
  1 ^ 2 // logical xor                            //> res8: Int(3) = 3
  1 << 2 // shift left                            //> res9: Int(4) = 4

  // Boolean operations
  true                                            //> res10: Boolean(true) = true
  false                                           //> res11: Boolean(false) = false
  1 > 2 // greater than                           //> res12: Boolean(false) = false
  1 < 2 // less than                              //> res13: Boolean(true) = true
  1 == 2 // equals                                //> res14: Boolean(false) = false
  1 >= 2 // greater than or equal                 //> res15: Boolean(false) = false
  1 != 2 // less than or equal                    //> res16: Boolean(true) = true
  true || false // or                             //> res17: Boolean(true) = true
  true && false // and                            //> res18: Boolean(false) = false

  // If-Expression
  if (1 > 2) 4 else 5 // greater than             //> res19: Int = 5
  if (1 < 2) 6 else 7 // less than                //> res20: Int = 6
  if (width == 1024 && height == 576) "PAL"       //> res21: Any = ()
  if (width / height == 16 / 9) "PAL"             //> res22: Any = PAL
  val resolution = if (width / height == 16 / 9) "PAL"
                                                  //> resolution  : Any = PAL
  if (width / height == 16 / 9) "PAL" else "Unknown"
                                                  //> res23: java.lang.String = PAL
  
  // TODO Develop an if-expression that can distinguish
  // between SXGA(1280x1024), HD 720(16:9) and a HD 1080(16:9) resolution based on width, height and ratio
val h = 1080                                      //> h  : Int = 1080
val w = 1080*16/9                                 //> w  : Int = 1920
if (w == 1280 && h == 1024) "SXGA" else
	if (h == 1080 && w == 1080*16/9) "HD 1080" else
		if (h ==720 && w == 720*16/9) "HD 720" else
			"unknown"                 //> res24: java.lang.String = HD 1080
  // Loops
  var total1 = 18                                 //> total1  : Int = 18
  while (total1 < 17) total1 += 3
  total1                                          //> res25: Int = 18

  var total2 = 18                                 //> total2  : Int = 18
  do {
    total2 += 3
  } while (total2 < 17)
  total2                                          //> res26: Int = 21

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
// TODO Write a for-loop that produces the following output
// 12345678
// 22345678
// 33345678
// 44445678
// 55555678
// 66666678
// 77777778
// 88888888

for (i <-1 to 8; j <- 1 to 8) {
	print( if (i>j) i else j)
  if (j== 8) println
}                                                 //> 12345678
                                                  //| 22345678
                                                  //| 33345678
                                                  //| 44445678
                                                  //| 55555678
                                                  //| 66666678
                                                  //| 77777778
                                                  //| 88888888
}