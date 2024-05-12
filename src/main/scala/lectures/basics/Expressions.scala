package lectures.basics

object Expressions extends App {

  val x = 1 + 2 // expressions
  println("x = " + x)

  println("expression 2 + 3 * 4 = " +  (2 + 3 * 4))
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ..... side effects
  println(aVariable)

  // Instructions(do) VS Expressions(value)

  // IF expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  println(if (aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  val aWhile = while (i < 10) { // sideEffect - always returns Unit
    println(i)
    i += 1
  } // NEVER WRITE THIS AGAIN.

  // EVERYTHING in Scala is an Expression!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning


  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // 1. difference between "hello world" vs println("hello world")?  - value and the instruction
  // 2.

  val someValue = {
    2 < 3
  }
  println(someValue) // boolean

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  println(someOtherValue) // will return 42
}
