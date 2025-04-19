package com.elixirin
package exercises


abstract class MyList1[+A] {
  /*
    head = first element ofthe list
    tail = remainder of the list
    isEmpty = is this list empty
    add (int) => new list with this element added
    toString => a string representation of the list
   */

  def head: A
  def tail: MyList1[A]
  def isEmpty : Boolean
  def add[B >: A](n: B): MyList1[B]
  def printElement: String
  override def toString : String = "[" + printElement + "]"

  // Higher-Order Functions ( Functions which takes functions as parameter and/or return functions as result )
  def map[B](transformer: A => B) : MyList1[B]
  def flatMap[B](transformer: A => MyList1[B]): MyList1[B]
  def filter(predicate: A => Boolean): MyList1[A]

  // Concatenation
  def ++[B >: A](list: MyList1[B]): MyList1[B]
}


object Empty1 extends MyList1[Nothing]  {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: Nothing = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[B >: Nothing] (n: B): MyList1[B] = new Cons1(n, Empty1)
  override def printElement: String = ""
  override def map[B](transformer: Nothing => B): MyList1[B] = Empty1
  override def flatMap[B](transformer: Nothing => MyList1[B]): MyList1[B] = Empty1
  override def filter(predicate: Nothing => Boolean): MyList1[Nothing] = Empty1
  override def ++[B >: Nothing](list: MyList1[B]): MyList1[B] = list
}


class Cons1[+A](h: A, t: MyList1[A]) extends MyList1[A] {
  override def head: A = h
  override def tail: MyList1[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](n: B): MyList1[B] = new Cons1(n, this)
  override def printElement: String =
    if (t.isEmpty)  "" + h
    else h + " " + t.printElement


  override def map[B](transformer: A => B): MyList1[B] = {
    new Cons1(transformer(h), t.map(transformer))
  }


  override def filter(predicate: A => Boolean): MyList1[A] = {
    if (predicate(h)) new Cons1(h, t.filter(predicate))
    else t.filter(predicate)
  }


  override def ++[B >: A](list: MyList1[B]): MyList1[B] = new Cons1(h, t ++ list)


  override def flatMap[B](transformer: A => MyList1[B]): MyList1[B] =
    transformer(h) ++ t.flatMap(transformer)
}

object ListTest1 extends App {
  val listOfIntegers: MyList1[Int] = new Cons1(1, new Cons1(2, new Cons1(3, Empty1)))
  val anotherListOfIntegers: MyList1[Int] = new Cons1(4, new Cons1(5,  Empty1))
  val listOfStrings: MyList1[String] = new Cons1("Hello", new Cons1("Scala", Empty1))
  println(listOfStrings.toString)
  println(listOfIntegers.toString)

  println(listOfIntegers.map(new Function1[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }).toString)

  println(listOfIntegers.filter(new Function1[Int, Boolean] {
    override def apply(element: Int): Boolean = element % 2 == 0
  }).toString)


  println(listOfIntegers ++ anotherListOfIntegers)

  println(listOfIntegers.flatMap(new Function1[Int, MyList1[Int]] {
    override def apply(element: Int): MyList1[Int] = new Cons1(element, new Cons1(element + 1, Empty1))
  }))
}

