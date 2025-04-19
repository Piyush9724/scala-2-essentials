package com.elixirin
package exercises

abstract class MyList2[+A] {
  /*
    head = first element ofthe list
    tail = remainder of the list
    isEmpty = is this list empty
    add (int) => new list with this element added
    toString => a string representation of the list
   */

  def head: A
  def tail: MyList2[A]
  def isEmpty : Boolean
  def add[B >: A](n: B): MyList2[B]
  def printElement: String
  override def toString : String = "[" + printElement + "]"

  // Higher-Order Functions ( Functions which takes functions as parameter and/or return functions as result )
  def map[B](transformer: A => B) : MyList2[B]
  def flatMap[B](transformer: A => MyList2[B]): MyList2[B]
  def filter(predicate: A => Boolean): MyList2[A]

  // Concatenation
  def ++[B >: A](list: MyList2[B]): MyList2[B]
}


object Empty2 extends MyList2[Nothing]  {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: Nothing = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[B >: Nothing] (n: B): MyList2[B] = new Cons2(n, Empty2)
  override def printElement: String = ""
  override def map[B](transformer: Nothing => B): MyList2[B] = Empty2
  override def flatMap[B](transformer: Nothing => MyList2[B]): MyList2[B] = Empty2
  override def filter(predicate: Nothing => Boolean): MyList2[Nothing] = Empty2
  override def ++[B >: Nothing](list: MyList2[B]): MyList2[B] = list
}


class Cons2[+A](h: A, t: MyList2[A]) extends MyList2[A] {
  override def head: A = h
  override def tail: MyList2[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](n: B): MyList2[B] = new Cons2(n, this)
  override def printElement: String =
    if (t.isEmpty)  "" + h
    else h + " " + t.printElement


  override def map[B](transformer: A => B): MyList2[B] = {
    new Cons2(transformer(h), t.map(transformer))
  }


  override def filter(predicate: A => Boolean): MyList2[A] = {
    if (predicate(h)) new Cons2(h, t.filter(predicate))
    else t.filter(predicate)
  }


  override def ++[B >: A](list: MyList2[B]): MyList2[B] = new Cons2(h, t ++ list)


  override def flatMap[B](transformer: A => MyList2[B]): MyList2[B] =
    transformer(h) ++ t.flatMap(transformer)
}

object ListTest1 extends App {
  val listOfIntegers: MyList2[Int] = new Cons2(1, new Cons2(2, new Cons2(3, Empty2)))
  val anotherListOfIntegers: MyList2[Int] = new Cons2(4, new Cons2(5,  Empty2))
  val listOfStrings: MyList2[String] = new Cons2("Hello", new Cons2("Scala", Empty2))
  println(listOfStrings.toString)
  println(listOfIntegers.toString)

  println(listOfIntegers.map(element => element * 2).toString)

  println(listOfIntegers.filter(element => element % 2 == 0).toString)


  println(listOfIntegers ++ anotherListOfIntegers)

  println(listOfIntegers.flatMap(element => new Cons2(element, new Cons2(element + 1, Empty2))))

  // _
  println(listOfIntegers.map( _ * 2).toString)

  println(listOfIntegers.filter( _ % 2 == 0).toString)


  println(listOfIntegers ++ anotherListOfIntegers)

  // _ Notation won't work for this following line because the element is used twice in the expression and each _ stands for one var
  println(listOfIntegers.flatMap((element: Int) => new Cons2(element, new Cons2(element + 1, Empty2))))
}

