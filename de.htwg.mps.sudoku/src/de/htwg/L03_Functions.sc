object L03_Functions {
   // Functions

  // Functions without return type
   def max1(x: Int, y: Int) {
    if (x > y) print(x)
    else print(y)
  }                                               //> max1: (x: Int, y: Int)Unit
  
  def max2(x: Int, y: Int):Unit = {
    if (x > y) print(x)
    else print(y)
  }                                               //> max2: (x: Int, y: Int)Unit
  
  def max3(x: Int, y: Int): Int = {
    if (x > y) x
    else y
  }                                               //> max3: (x: Int, y: Int)Int
  
  def max4(x: Int, y: Int) = if (x > y) x else y  //> max4: (x: Int, y: Int)Int

  max4(6, 7)                                      //> res0: Int = 7

  def gcd(x: Long, y: Long): Long =
    if (y == 0) x else gcd(y, x % y)              //> gcd: (x: Long, y: Long)Long

  gcd(96, 128)                                    //> res1: Long = 32
  
  // TODO Write a function that generates a list
  // of all primes between two given numbers
  
  def primes(min:Int, max:Int) = {
  	var sieve = (2 to max).toList
  	for(i <- 2 to max/2; j <- 2 to i) sieve = sieve - i*j
  	//sieve.dropWhile(i=>i<min)
  	while (sieve.head < min) {sieve = sieve.tail}
  	sieve
  }                                               //> primes: (min: Int, max: Int)List[Int]
  
  primes(12, 40)                                  //> res2: List[Int] = List(13, 17, 19, 23, 29, 31, 37)
  

}