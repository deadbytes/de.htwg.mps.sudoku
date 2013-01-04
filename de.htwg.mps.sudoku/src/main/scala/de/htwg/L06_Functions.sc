object L06_Functions {

  //Functions
  val list = List(1, 7, 2, 8, 5, 6, 3, 9, 14, 12, 4, 10)
                                                  //> list  : List[Int] = List(1, 7, 2, 8, 5, 6, 3, 9, 14, 12, 4, 10)

  def odd(inLst: List[Int]): List[Int] = {
    if (inLst == Nil) Nil
    else if (inLst.head % 2 == 1) inLst.head :: odd(inLst.tail)
    else odd(inLst.tail)
  }                                               //> odd: (inLst: List[Int])List[Int]

  odd(list)                                       //> res0: List[Int] = List(1, 7, 5, 3, 9)

  def even(inLst: List[Int]): List[Int] = {
    if (inLst == Nil) Nil
    else if (inLst.head % 2 == 0) inLst.head :: even(inLst.tail)
    else even(inLst.tail)
  }                                               //> even: (inLst: List[Int])List[Int]

  even(list)                                      //> res1: List[Int] = List(2, 8, 6, 14, 12, 4, 10)
  
  //Functions as parameter
  def isodd(v: Int) = v % 2 == 1                  //> isodd: (v: Int)Boolean

  def filter1(inLst: List[Int], cond: (Int) => Boolean): List[Int] = {
    if (inLst == Nil) Nil
    else if (cond(inLst.head)) inLst.head :: filter1(inLst.tail, cond)
    else filter1(inLst.tail, cond)
  }                                               //> filter1: (inLst: List[Int], cond: Int => Boolean)List[Int]

  filter1(list, isodd)                            //> res2: List[Int] = List(1, 7, 5, 3, 9)

  //Anonymous functions
  filter1(list, (v: Int) => v % 2 == 0)           //> res3: List[Int] = List(2, 8, 6, 14, 12, 4, 10)

  //Generic types
  def filter2[T](inLst: List[T], cond: (T) => Boolean): List[T] = {
    if (inLst == Nil) Nil
    else if (cond(inLst.head)) inLst.head :: filter2(inLst.tail, cond)
    else filter2(inLst.tail, cond)
  }                                               //> filter2: [T](inLst: List[T], cond: T => Boolean)List[T]

  filter2(list, (v: Int) => v % 2 == 0)           //> res4: List[Int] = List(2, 8, 6, 14, 12, 4, 10)

  val lstd = List(1.5, 7.4, 2.3, 8.1, 5.6, 6.2, 3.5, 9.2, 14.6, 12.91, 4.23, 10.04)
                                                  //> lstd  : List[Double] = List(1.5, 7.4, 2.3, 8.1, 5.6, 6.2, 3.5, 9.2, 14.6, 1
                                                  //| 2.91, 4.23, 10.04)
  filter2(lstd, (v: Double) => v > 5)             //> res5: List[Double] = List(7.4, 8.1, 5.6, 6.2, 9.2, 14.6, 12.91, 10.04)

  val stringlist = List("It's", "a", "far", "far", "better", "thing", "I", "do", "now")
                                                  //> stringlist  : List[java.lang.String] = List(It's, a, far, far, better, thin
                                                  //| g, I, do, now)

  filter2(stringlist, (v: String) => v.length > 3)//> res6: List[java.lang.String] = List(It's, better, thing)

  //Built-in functions
  stringlist.filter((v: String) => v.length > 3)  //> res7: List[java.lang.String] = List(It's, better, thing)

  stringlist.filter(v => v.length > 3)            //> res8: List[java.lang.String] = List(It's, better, thing)

  stringlist.filter(_.length > 3)                 //> res9: List[java.lang.String] = List(It's, better, thing)

  stringlist.map(_.toList)                        //> res10: List[List[Char]] = List(List(I, t, ', s), List(a), List(f, a, r), Li
                                                  //| st(f, a, r), List(b, e, t, t, e, r), List(t, h, i, n, g), List(I), List(d, 
                                                  //| o), List(n, o, w))
  stringlist.flatMap(_.toList)                    //> res11: List[Char] = List(I, t, ', s, a, f, a, r, f, a, r, b, e, t, t, e, r,
                                                  //|  t, h, i, n, g, I, d, o, n, o, w)
  stringlist.sort(_ < _)                          //> res12: List[java.lang.String] = List(I, It's, a, better, do, far, far, now,
                                                  //|  thing)

  stringlist.sort(_ > _)                          //> res13: List[java.lang.String] = List(thing, now, far, far, do, better, a, I
                                                  //| t's, I)

  stringlist.sort(_.toUpperCase < _.toUpperCase)  //> res14: List[java.lang.String] = List(a, better, do, far, far, I, It's, now,
                                                  //|  thing)

  list.foldLeft(0)(_ + _)                         //> res15: Int = 81

  val wordlist = List("Once", "more", "unto", "the", "breach")
                                                  //> wordlist  : List[java.lang.String] = List(Once, more, unto, the, breach)
  //Function chaining
  wordlist.flatMap(_.toList).map(_.toUpperCase).removeDuplicates.sort(_ < _)
                                                  //> res16: List[Char] = List(A, B, C, E, H, M, N, O, R, T, U)

  def uniqueLetters(list: List[String]) = list.flatMap(_.toList).map(_.toUpperCase).removeDuplicates.sort(_ < _)
                                                  //> uniqueLetters: (list: List[String])List[Char]

  uniqueLetters(wordlist)                         //> res17: List[Char] = List(A, B, C, E, H, M, N, O, R, T, U)
}