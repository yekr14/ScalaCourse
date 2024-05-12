package lectures.oop

object Inheritance extends App {

  val kotik = new Cat
  // kotik.eat() allowed only inside the class
  kotik.dinner

  val dog = new Dog
  dog.eat
  println(dog.creatureType)

  val dog2 = new Dog2("K9")
  dog2.dinner
  println(dog2.creatureType)

  //polimorphism
  val unknownAnimal: Animal = new Dog2("K9")
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other files


  class Animal {
    val creatureType = "wild"
    def eat = println("nom nom nom")
  }

  //single class inheritance - only one extends allowed
  class Cat extends Animal {
    def dinner = {
      println("I'm hungry")
      eat
      println("I'm full")
    }
  }

  class Dog extends Animal {
    override val creatureType = "domestic"
    override def eat: Unit = println("gauf gauf gauf")
  }

  class Dog2(override val creatureType: String) extends Dog {
    override def eat: Unit = println("kray krya krya")

     def dinner = {
      println("I'm hungry")
      eat
       //super.eat
      println("I'm full")
    }
  }

  //constructors

  class Person (name:String, age :Int ){
    //Auxiliary Class Constructors
    def this(name: String) = this(name, 0)
  }
                                                    //define parent constructor parameters - otherwise will not compile
  class Adult (name:String, age :Int, idCard: Int ) extends Person(name, age)
}
