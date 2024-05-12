package lectures.oop

import scala.language.postfixOps

object MethodNotations extends App {

  val mary = new Person("Mary", "Brown", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // infix notation = operator notation (syntactic sugar)


  // "operators" in Scala
  val tom = new Person("Tom", "Holland", "Fight Club")
  println(mary hangOut tom)
  println(mary + tom)

  println(1 + 2)
  println(1.+(2))

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply(5))
  println(mary.apply())
  println(mary()) // equivalent
  println((mary + "the Rockstar").apply())
  println((+mary).age)
  println(mary learnsScala)
  println(mary(10))


  class Person(val firstName: String, surname: String = "Doe", val favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def hangOut(person: Person): String = s"${this.firstName} is hanging out with ${person.firstName}"
    def +(person: Person): String = s"${this.firstName} is hanging out with ${person.firstName}"
    def +(nickname: String): Person = new Person(firstName = s"$firstName ($nickname)", favouriteMovie = favouriteMovie)

    def unary_! : String = s"$firstName, what the heck?!"
    def unary_+ : Person = new Person(firstName = firstName, favouriteMovie = favouriteMovie, age = age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $firstName and I like $favouriteMovie"
    def apply(n: Int): String = s"$firstName watched $favouriteMovie $n times"
    def learns(thing: String) = s"$firstName is learning $thing"
    def learnsScala = this learns "Scala"
  }
}
