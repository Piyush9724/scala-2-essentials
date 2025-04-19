package com.elixirin
package lectures.part03FunctionalProgramming

object Ep02AnonymousFunctions extends App {
  // Problem: instantiating a function is tied to the OO way
  val doubler = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

  // Use syntactic sugar called as Anonymous Function  called as LAMBDA
  // name comes from Lambda Calculus -> Mathematical Representation of Function Programming
  // Formalized by Alonzo Church in 1930s
  val doubler1 = (x: Int) => x * 2
  println(doubler1(4))
  /*
    This Lambda (x: Int) => x * 2 is a value is an instance of Function1
    val doubler1: Int => Int = (x: Int) => x * 2
    can be written as
    val doubler1: Int => Int = x => x * 2
  */

  // Syntax for multiple parameters
  val adder = (a: Int, b: Int) => a + b
  // val adder: (Int, Int) => Int = (a, b) => a + b

  // No Params
  val justDoSomething = () => 3
  // val justDoSomething: () => Int = () => 3

  // careful
  println(justDoSomething) // Function itself
  println(justDoSomething()) // call


  // curly braces with Lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }


  // More Syntactic Sugar
  // val niceIncrementer: Int => Int = (x:Int) => x + 1  can be written as
  val niceIncrementer: Int => Int = _ + 1

  val niceAdder: (Int, Int) => Int = _ + _  // equivalent to (a, b) => a + b


  /*
    1. MyList: replace All FunctionX calls with Lambdas
    2. ReWrite the "special" Adder as anonymous functions

  */

  def superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  def superAdder1 = (x: Int) => (y: Int) => x + y // Curried Functions

}