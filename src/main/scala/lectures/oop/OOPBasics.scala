/*package lectures.oop

import java.time.{LocalDate, Year}

object OOBasics extends App {

  //val personNonGrata = new Person
  val personNonGrata = new Person("John", 26)
  println(personNonGrata) // shown pointer in memory
  println(personNonGrata.age) // only if val added
  println(personNonGrata.x) // x is accessible field

  personNonGrata.greet("Daniel")
  personNonGrata.greet()

  val personGrata = new Person()
  personGrata.greet("Daniel")
  personGrata.greet()
  /*_________________________________________*/

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  novel.print()
  val novelCopy = novel.copy()
  novelCopy.print()

  println(novel.authorAge)
  println(novel.isWrittenBy(imposter))
  /*_________________________________________*/

  val counter = new Counter
  counter.increment().print
  counter.increment().increment().increment().print
  counter.increment(10).print

}

//class parameters are not fields
//you can't do person.age
class Person(name: String, val age: Int) // constructor
{
  // body
  val x = 2

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)

  def this() = this("John Doe")
}



/*
  Novel and a Writer

  Writer: first name, surname, year
    - method fullname

  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel


 */

class Writer(val firstName: String, val surname: String, val yearOfBirth: Int) {
  def fullName(firstName: String, surname: String): String = firstName + " " + surname
}

class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {
  def authorAge = yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer) = author == this.author

  def copy() = new Novel(this.name, LocalDate.now().getYear, this.author)

  def print() = println(s"The ${this.name} is written by ${this.author.firstName} " +
     s"${this.author.surname} in ${this.yearOfRelease}")
}

/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */

class Counter(val x: Int = 1) {
  def current(counter: Counter) = counter.x
  def increment() = new Counter(this.x + 1)
  def increment(amount: Int) = new Counter(this.x + amount)
  def decrement() = new Counter(this.x - 1)
  def decrement(amount: Int) = new Counter(this.x - amount)

  def print = println(this.x)
}*/