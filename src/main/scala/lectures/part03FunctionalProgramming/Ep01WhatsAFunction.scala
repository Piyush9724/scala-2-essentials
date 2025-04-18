package com.elixirin
package lectures.part03FunctionalProgramming

object Ep01WhatsAFunction extends App {

  // DREAM   : use functions as FIRST CLASS CITIZENS
  // Problem : We come from OO World Everything is classes and object

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  // Advantage of Scala as opposed to Java is we can actually call doubler(2) like it were a function
  // doubler act as a Function

  println(doubler(2))

  // Scala supports these function types of out of th e box
  // function types =  Function1[A, B]

  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("3") + 4)

  // Scala supports 22 Function Types
  // Example
  val adder =  new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  //  Syntactic Sugar
  val adder3: ((Int, Int) => Int) =  new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // More Syntactic Sugar
  val adder2: Function2[Int, Int, Int] =  new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }


  // Function Types, Function2[A, B, R] === (A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*

  */

}

class Action {
  def execute(element: Int): String = ???
}

// What we can do max make this class more generic

trait Action1[A, B] {
  def execute(element: A ): B = ???
}

// A better option would be to name this trait MyFunction and update the name of the method to apply

trait MyFunction[A, B] {
  def apply(element: A): B = ???
}