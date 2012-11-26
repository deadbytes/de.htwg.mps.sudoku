object L09_Implicit {
  /* Adding ! as a method on int's */
  def fact(n: Int): BigInt =
    if (n == 0) 1 else fact(n-1) * n              //> fact: (n: Int)BigInt
  class Factorizer(n: Int) {
    def ! = fact(n)
  }
  implicit def int2fact(n: Int) = new Factorizer(n)
                                                  //> int2fact: (n: Int)L09_Implicit.Factorizer
  
  println("10! = " + (10!))                       //> 10! = 3628800
}