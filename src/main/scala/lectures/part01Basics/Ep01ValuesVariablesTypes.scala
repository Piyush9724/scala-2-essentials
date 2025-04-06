package com.elixirin
package lectures.part01Basics

object Ep01ValuesVariablesTypes extends App {
  // Printing a welcome message
  println("Welcome to Scala!")

  // Declaring a value
  val x: Int = 42
  println(x) // Prints: 42

  // Declaring a variable
  var y: Int = 10
  println(y) // Prints: 10
  y = 20 // Reassigning the variable
  println(y) // Prints: 20

  // Type inference example
  val inferredValue = 100 // Compiler infers this as Int
  println(inferredValue) // Prints: 100

  // Basic data types
  val name: String = "Hello, Scala"
  val isScalaFun: Boolean = true
  val character: Char = 'S'
  val shortValue: Short = 12345
  val longValue: Long = 12345678901234L
  val floatValue: Float = 2.0F
  val doubleValue: Double = 3.14

  // Example of variable reassignment
  var counter: Int = 0
  counter += 1 // Side effect: changing the value of counter
  println(counter) // Prints: 1
}
