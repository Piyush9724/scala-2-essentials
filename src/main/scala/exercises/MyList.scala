package com.elixirin
package exercises

trait MyPredicate[-T] {
  def test(element: T) : Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}

class EvenPredicate extends MyPredicate[Int] {
  override def test(element: Int): Boolean = element % 2 == 0
}

class StringToIntTransformer extends MyTransformer[String, Int] {
  override def transform(x: String): Int = x.toInt
}

abstract class MyList[+A] {
  /*
    head = first element ofthe list
    tail = remainder of the list
    isEmpty = is this list empty
    add (int) => new list with this element added
    toString => a string representation of the list
   */

  def head: A
  def tail: MyList[A]
  def isEmpty : Boolean
  def add[B >: A](n: B): MyList[B]
  def printElement: String
  override def toString : String = "[" + printElement + "]"
  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
}


object Empty extends MyList[Nothing]  {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: Nothing = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[B >: Nothing] (n: B): MyList[B] = new Cons(n, Empty)
  override def printElement: String = ""
  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
}


class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h
  override def tail: MyList[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](n: B): MyList[B] = new Cons(n, this)
  override def printElement: String =
    if (t.isEmpty)  "" + h
    else h + " " + t.printElement

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  //override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))
  println(listOfStrings.toString)
  println(listOfIntegers.toString)

}



/*
  // Earlier Version without generics
  abstract class MyList[+A] {
    /*
      head = first element ofthe list
      tail = remainder of the list
      isEmpty = is this list empty
      add (int) => new list with this element added
      toString => a string representation of the list
     */

    def head: A
    def tail: MyList[A]
    def isEmpty : Boolean
    def add[B >: A](n: B): MyList[B]
    def printElement: String
    override def toString : String = "[" + printElement + "]"
  }


  object Empty extends MyList {
    override def head: Int = throw new NoSuchElementException
    override def tail: MyList = throw new NoSuchElementException
    override def isEmpty: Boolean = true
    override def add(n: Int): MyList = new Cons(n, Empty)
    override def printElement: String = ""
  }


  class Cons(h: Int, t: MyList) extends MyList {
    override def head: Int = h
    override def tail: MyList = t
    override def isEmpty: Boolean = false
    override def add(n: Int): MyList = new Cons(n, this)
    override def printElement: String =
      if (t.isEmpty)  "" + h
      else h + " " + t.printElement
  }

  object ListTest extends App {
    val list = new Cons(1, Empty)
    println(list.head)
    val list1 = new Cons(1, new Cons(2, new Cons(3, Empty)))
    println(list1.tail.head)
    println(list1.add(4).head)
    println(list1.isEmpty)

    println(list1.toString)
  }
*/