package exercises

/*
 head = first element of  the  list
 tail = remainder of the list
 isEmpty = is this list empty
 add(int) => new list with this element added
 toString => a string representation of the list
*/

abstract class MyList {
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object EmptyList extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new NonEmptyList(element, EmptyList)
  def printElements: String = ""
  override def toString: String = "I'm an empty list"
}

class NonEmptyList(headElement: Int, tailElement: MyList) extends MyList {
  def head: Int = headElement
  def tail: MyList = tailElement
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new NonEmptyList(element, this)
  def printElements: String = {
    if (tailElement.isEmpty) "" + headElement
    else headElement + " " + tailElement.printElements
  }
}

object ListTest extends App {
  val list: MyList = new NonEmptyList(1, new NonEmptyList(2, new NonEmptyList(3, EmptyList)))
  println(list.toString)

  println(list.add(4).toString)
}