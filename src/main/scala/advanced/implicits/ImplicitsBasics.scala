package advanced.implicits

object ImplicitsBasics extends App {


  case class Person(name: String, age: Int)

  val personList = List(
    Person("Arkadii", 27),
    Person("Boris", 25),
    Person("Denis", 23),
    Person("Sergey", 45),
    Person("Valeria", 33),
    Person("Yurii", 29)
  )


  implicit def orderAlphabetically: Ordering[Person] = Ordering.fromLessThan((a, b) => a.name.compareTo(b.name) < 0)

  println(personList.sorted)


  case class Purchase(name: String, nUnit: Int, unitPrice: Double) {
    implicit def oderByTotal: Ordering[Purchase] = Ordering.fromLessThan((a, b) => a.nUnit * a.unitPrice < b.nUnit * b.unitPrice)
  }

  object PriceOrdering {
    implicit def orderByPrice: Ordering[Purchase] = Ordering.fromLessThan((a, b) => a.unitPrice < b.unitPrice)
  }

  object UnitOrdering {
    implicit def orderByPrice: Ordering[Purchase] = Ordering.fromLessThan((a, b) => a.nUnit < b.nUnit)
  }

  val purchaseList = List(
    Purchase("pear", 4, 1.0),
    Purchase("mop", 1, 10),
    Purchase("soda", 2, 0.33),
    Purchase("apple", 5, 1.5),
    Purchase("hammer", 7, 13)
  )

  //don't clear how to fix  - bug in example ?
  // println(purchaseList.sorted)

}
