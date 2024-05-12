package lectures.basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }
  println(aFunction("hello", 3))

  def aShortFunction(a: String, b: Int): String = a + " " + b
  println(aShortFunction("goodbye", 5))


  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  //println(aParameterlessFunction) works only in Scala 2, not in Scala 3

  def aRepetativeFunc(aString: String, n: Int): String = { // always specify return types of recursive functions
    if (n == 1) aString
    else {
      aString + " " + aRepetativeFunc(aString, n - 1)
    }
  }

  println(aRepetativeFunc("myau", 5))
  // WHEN YOU NEED LOOPS, USE RECURSION.

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  aFunctionWithSideEffects("Pirojok")

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n - 1)
  }

  // Tasks
  /*
      1.  A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
      2.  Factorial function 1 * 2 * 3 * .. * n
      3.  A Fibonacci function
          f(1) = 1
          f(2) = 1
          f(n) = f(n - 1) + f(n - 2)
      4.  Tests if a number is prime.
     */


  //1
  def greetingUnitFunction(name: String, age: Int): Unit = println(s"Hi, my name is $name and I am $age years old.")
  greetingUnitFunction("Katarina", 27)
  //see the difference between return types
  def greetingFunction(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old."
  }

  greetingFunction("Katarina", 27)
  println(greetingFunction("Ivan", 35))

  //2
  def factorialFunction(number: Int): Int = {
    if (number <= 0) 1
    else number * factorialFunction(number - 1)
  }
  println(factorialFunction(5)) //expect 120

  //3
  def fibonacciFunction(number: Int): Int = {
    if (number <= 2) 1
    else fibonacciFunction(number - 1) + fibonacciFunction(number - 2)
  }

  println(fibonacciFunction(8)) // 1 1 2 3 5 8 13 21 -> expect 21

  //4
  def isNumberPrime(number:Int): Boolean={
    def primeUntil(t:Int): Boolean = {
      if (t <= 1) true
      else number % t != 0 && primeUntil(t - 1)
    }
    primeUntil(number / 2)
  }

  println(isNumberPrime(37))
  println(isNumberPrime(2003))
  println(isNumberPrime(37 * 17))
}
