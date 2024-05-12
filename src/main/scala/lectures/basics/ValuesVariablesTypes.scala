package lectures.basics

object ValuesVariablesTypes extends App {

  val x = 42
  println(x)

  // x=2 VALS are constants and are immutable

  val aString: String = "hello"
  print(aString)
  val anotherString: String = "goodBuy"
  println(anotherString)

  val aChar: Char = 'a' // note the single quote
  println(aChar + " is a type of " + aChar.getType)

  // val aShort:Short = 45678329 // compiler will complain about type overflow
  val aShort: Short = 4567
  println(aShort + " is a type of " + aShort.getClass)

  val aDouble: Double = 4.0
  println(aDouble + " is a type of " + aDouble.getClass)

  val aFloat: Float = 4.0f
  println(aFloat + " is a type of " + aFloat.getClass)


  var aVariable: Int = 5
  aVariable = 10 // no compilation error
}
