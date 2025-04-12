package com.elixirin
package lectures.part02OOP

object Ep01OOBasics extends App {
  val aPerson = new Person("John", 26)
  println(aPerson)
  println(aPerson.age)
  aPerson.greet("Piyush")
}


class Person(name: String, val age: Int) { // Constructor
  // body
  val x = 2

  println(1+2)

  //method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  //overloading
  def greet(): Unit  = println(s"Hi, I am $name")

  //multiple constructors
  def this(name: String) = this(name, 0)
  //implementation of auxiliary constructor should only be call to another constructor
}
// class parameters are NOT FIELDS
