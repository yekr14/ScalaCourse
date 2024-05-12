package lectures.oop

object Objects extends App {
  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john) // refers to different instances of Person class

  val person1 = Person
  val person2 = Person
  println(person1 == person2) // refers to the sme singleton Object Person
}

class Person(val name: String) {
}

object Person { // type + its only instance
  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  //instead it has val
  // "static"/"class" - level functionality
  val N_EYES = 2

  def canFly: Boolean = false
}
