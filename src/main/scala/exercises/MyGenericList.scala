package exercises

/*
 head = first element of  the  list
 tail = remainder of the list
 isEmpty = is this list empty
 add(int) => new list with this element added
 toString => a string representation of the list
*/

abstract class MyGenericList[+A] {
  def head: A
  def tail: MyGenericList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyGenericList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object GenericEmptyList extends MyGenericList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyGenericList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add [B >: Nothing](element: B): MyGenericList[B] = new NonEmptyGenericList(element, GenericEmptyList)
  def printElements: String = ""
  override def toString: String = "I'm an empty list"
}

class NonEmptyGenericList[+A](headElement: A, tailElement: MyGenericList[A]) extends MyGenericList[A] {
  def head: A = headElement
  def tail: MyGenericList[A] = tailElement
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyGenericList[B] = new NonEmptyGenericList(element, this)
  def printElements: String = {
    if (tailElement.isEmpty) "" + headElement
    else headElement.toString + " " + tailElement.printElements
  }
}

object GenericListTest extends App {
  println("List with ints")
  val list: MyGenericList[Int] =
    new NonEmptyGenericList(1, 
      new NonEmptyGenericList(2, 
        new NonEmptyGenericList(3, GenericEmptyList)))
  println(list.toString)

  println(list.add(4).toString)

  println("List with string")
  val list2: MyGenericList[String] =
    new NonEmptyGenericList("kate",
      new NonEmptyGenericList("mate",
        new NonEmptyGenericList("late", GenericEmptyList)))
  println(list2.toString)

  println(list2.add("wate").toString)
  
}