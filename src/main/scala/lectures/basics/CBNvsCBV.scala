package lectures.basics

object CBNvsCBV extends App {

  //here x is a value
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // here x is an expression and computed every time function is called
  // useful for delayed computing / failures / streams
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

}
