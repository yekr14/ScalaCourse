package lectures.basics

import scala.annotation.tailrec

object Recursion extends App {


  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }

  println(factorial(10))
  //  println(factorial(5000)) will cause stackOverflow exception, cause recursive call is too deep

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  // how it works
  /*
      anotherFactorial(10) = factHelper(10, 1)
      = factHelper(9, 10 * 1)
      = factHelper(8, 9 * 10 * 1)
      = factHelper(7, 8 * 9 * 10 * 1)
      = ...
      = factHelper(2, 3 * 4 * ... * 10 * 1)
      = factHelper(1, 1 * 2 * 3 * 4 * ... * 10)
      = 1 * 2 * 3 * 4 * ... * 10

     */
  println(anotherFactorial(5000))


  //Tasks
  /*
      1.  Concatenate a string n times
      2.  IsPrime function tail recursive
      3.  Fibonacci function, tail recursive.
     */

  //1
  @tailrec
  def concatString(aString: String, n: Int, accamulator: String): String = {
    if (n <= 0) accamulator
    else concatString(aString, n - 1, aString + " " + accamulator)
  }

  println(concatString("myau", 5, ""))

  //2
  //too lazy

  //3
  def fibonacciFunction(n: Int): Int = {
    @tailrec
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacciFunction(8)) // 1 1 2 3 5 8 13, 21

}


