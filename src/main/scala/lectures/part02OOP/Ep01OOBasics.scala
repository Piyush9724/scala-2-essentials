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

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
}
// class parameters are NOT FIELDS

