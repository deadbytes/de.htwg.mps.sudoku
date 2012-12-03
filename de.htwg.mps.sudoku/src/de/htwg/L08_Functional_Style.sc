object functional {

  //Functions
  def f(x: Int) = x + 1                           //> f: (x: Int)Int
  f(5)                                            //> res0: Int = 6
  f{5}                                            //> res1: Int = 6

  //Anonymous Functions or Function literals

  (x: Int) => x + 1                               //> res2: Int => Int = <function1>

  //Syntactic sugar
  val numbers = List(1, 2, 3, 4, 5)               //> numbers  : List[Int] = List(1, 2, 3, 4, 5)
  numbers.foreach((x: Int) => print(x))           //> 12345
  numbers.foreach((x) => print(x))                //> 12345
  numbers.foreach(x => print(x))                  //> 12345
  numbers.foreach(print(_))                       //> 12345
  numbers.foreach(print _)                        //> 12345
  numbers.foreach(print)                          //> 12345
  numbers foreach print                           //> 12345

  //Higher order functions (Functions that accept a function as parameter)
  numbers.foreach(x => f(x))
  numbers.foreach(f(_))
  numbers.foreach(f)
  numbers foreach f

  numbers.map(x => f(x))                          //> res3: List[Int] = List(2, 3, 4, 5, 6)

  numbers.filter(x => x > 3)                      //> res4: List[Int] = List(4, 5)

  numbers.map(x => x + 1)                         //> res5: List[Int] = List(2, 3, 4, 5, 6)

  numbers.filter(_ > 3)                           //> res6: List[Int] = List(4, 5)

  numbers.map(_ + 1)                              //> res7: List[Int] = List(2, 3, 4, 5, 6)

  // Fun with higher order functions
  List(-10, -5, 0, 5, 10)
    .filter(_ > 0)
    .map(x => x * x)
    .sortWith(_ > _)
    .foreach(println)                             //> 100
                                                  //| 25

  List(-10, -5, 0, 5, 10)
    .map(x => x * x)
    .filter(_ > 0)
    .sortWith(_ > _)
    .foreach(println)                             //> 100
                                                  //| 100
                                                  //| 25
                                                  //| 25

  // A function imperative style
  def fib_imp(n: Int): Int = {
    if (n <= 1) return n else {
      var res = 0
      var f1 = 0
      var f2 = 1
      for (i <- 2 to n) {
        res = f1 + f2
        f1 = f2
        f2 = res
      }
      res
    }
  }                                               //> fib_imp: (n: Int)Int
  fib_imp(8)                                      //> res8: Int = 21

  // A function functional style
  def fib_fun(x: Int): Int = x match {
    case 0 => 0;
    case 1 => 1
    case _ => fib_fun(x - 2) + fib_fun(x - 1)
  }                                               //> fib_fun: (x: Int)Int

  fib_fun(8)                                      //> res9: Int = 21

  // A function imperative style
  def isPrime_imp(n: Int): Boolean = {
    for (i <- 2 until n)
      if (n % i == 0)
        return false
    true
  }                                               //> isPrime_imp: (n: Int)Boolean

  isPrime_imp(31)                                 //> res10: Boolean = true

  // A function functional style
  def isPrime(n: Int) =
    2 until n forall { n % _ != 0 }               //> isPrime: (n: Int)Boolean

  isPrime(31)                                     //> res11: Boolean = true

  //Closures
  //A closed term is a function without free variables
  def f1(x: Int) = x + 1                          //> f1: (x: Int)Int

  //An open term is a function with free variables
  var c = 1                                       //> c  : Int = 1
  def f2(x: Int) = x + c                          //> f2: (x: Int)Int
  // A closure is the function value of the open term, thus a closure closes the open term at runtime, by capturing the bindings of its free variables
  f2(5)                                           //> res12: Int = 6
  c = 10
  f2(5)                                           //> res13: Int = 15

  //Currying

  def f3(c: Int) = (x: Int) => x + c              //> f3: (c: Int)Int => Int
  f3(1)(5)                                        //> res14: Int = 6
  f3(10)(5)                                       //> res15: Int = 15
  f3(10) { 5 }                                    //> res16: Int = 15
  f3(10) {
    val z = 4
    f(z)
  }                                               //> res17: Int = 15

  // partially applied functions
  def f4 = f3(10)                                 //> f4: => Int => Int

  f4(5)                                           //> res18: Int = 15
  
  def f5(op:(Int, Int)=>Int) (x:Int, y:Int) = {
     op(x,y)
  }                                               //> f5: (op: (Int, Int) => Int)(x: Int, y: Int)Int
  def add(x:Int, y:Int) = x + y                   //> add: (x: Int, y: Int)Int
  f5(add) (5,1)                                   //> res19: Int = 6
  def f6 = f5(add) _                              //> f6: => (Int, Int) => Int
  f6(5,1)                                         //> res20: Int = 6

  // A practical example: msort

  def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }                                               //> msort: [T](less: (T, T) => Boolean)(xs: List[T])List[T]

  def intsort = msort((x: Int, y: Int) => x < y) _//> intsort: => List[Int] => List[Int]
  intsort(List(9, 2, 5, 7, 3, 8))                 //> res21: List[Int] = List(2, 3, 5, 7, 8, 9)

  def reverseintsort = msort((x: Int, y: Int) => x > y) _
                                                  //> reverseintsort: => List[Int] => List[Int]
  reverseintsort(List(9, 2, 5, 7, 3, 8))          //> res22: List[Int] = List(9, 8, 7, 5, 3, 2)

  def stringsort = msort((s1: String, s2: String) => s1.length < s2.length) _
                                                  //> stringsort: => List[String] => List[String]
  stringsort(List("coffee", "tee", "beer", "orangejuice"))
                                                  //> res23: List[String] = List(tee, beer, coffee, orangejuice)

  //reduceLeft, foldLeft
  def sum(list:List[Int]):Int = list match {
    case Nil => 0
    case _ => list.head + sum(list.tail)
  }                                               //> sum: (list: List[Int])Int
  
  
  sum(List(1,2,3,4,5))                            //> res24: Int = 15
  
  def product(list:List[Int]):Int = list match {
    case Nil => 1
    case _ => list.head + product(list.tail)
  }                                               //> product: (list: List[Int])Int
  product(List(1,2,3,4,5))                        //> res25: Int = 16
  
  def sum2(list:List[Int])=list.foldLeft(0)(_+_)  //> sum2: (list: List[Int])Int
  sum2(List(1,2,3,4,5))                           //> res26: Int = 15
  List(1,2,3,4,5).foldLeft(0)(_+_)                //> res27: Int = 15
  
  def product2(list:List[Int])=list.foldLeft(1)(_*_)
                                                  //> product2: (list: List[Int])Int
  product2(List(1,2,3,4,5))                       //> res28: Int = 120
  List(1,2,3,4,5).foldLeft(1)(_*_)                //> res29: Int = 120

}