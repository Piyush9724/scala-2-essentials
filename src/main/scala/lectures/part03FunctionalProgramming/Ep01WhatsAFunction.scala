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
  val adder: Function2[Int, Int, Int] =  new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  //  Syntactic Sugar
  val adder2: (Int, Int) => Int =  new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // Convert to Single Abstract Method
  val adder3: (Int, Int) => Int = (v1: Int, v2: Int) => v1 + v2
  // Function Types, Function2[A, B, R] === (A, B) => R

  println(adder(4,6))
  println(adder2(4,6))
  println(adder3(4,6))


  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
    1. Function which takes 2 Strings and Concatenate them
    2. transform the MyPredicate and MyTransformer into function Types
    3. Define a Function which takes an argument an int and returns another function which takes an Int and returns an Int
      - Define the type of the function
      - how to do it
  */

  // 1.
  val concatinator: (String, String) => String = (v1: String, v2:String) => v1 +" "+  v2
  println(concatinator("Hello", "Scala"))

  // 3. without using syntactic sugar
  // type of Function
  // Function1[Int, Function1[Int, Int]]
   def superAdder(x: Int) : Function1[Int, Int] = {
      new Function[Int, Int] {
        override def apply(v1: Int): Int = x + v1;
      }
   }

  // 3. with syntactic sugar
  def superAdder1(x: Int): Int => Int = {
    (y:Int) => x + y
  }
  val adder4 = superAdder(3)
  println(adder4(4))
  println(superAdder(3)(4)) // called as a curried function
  println(superAdder1(10)(20))
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