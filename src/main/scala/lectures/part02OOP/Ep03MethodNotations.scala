package com.elixirin
package lectures.part02OOP

import scala.language.postfixOps

object Ep03MethodNotations extends App {
  class Person (val name: String, favoriteMovie: String ) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} and ${person.name}" // Flexibility to name method as +
    def unary_! : String = s"$name What the heck"
    def isAlive: Boolean = true // Functions that do not use any parameter can be used with postfix notation
    def apply(): String = s"Hi my name is $name and my favorite movie is $favoriteMovie"
  }


  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation ( syntactic sugar)
  // object method parameter


  // "operators" in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom) // here the method hangOutWith acts an operator between mary and tom
  println(mary + tom)
  println(mary.+(tom)) // equivalent to the above line

  // Therefore ALL OPERATOR ARE METHODS.
  // Example Akka actors have ! ? as methods
  println(1 + 2)
  println(1.+(2)) // equivalent to the above line

  // Prefix Notation
  val x = -1   // equivalent to 1.unary_-
  val y = 1.unary_-  // equivalent to -1
  // unary_ prefix only works with - + ~ ! operators

  println(!mary)
  println(mary.unary_!) // equivalent to the above line


  // postfix notation
  println(mary.isAlive)
  println(mary isAlive) // equivalent to the above line

  println(mary.apply())
  println(mary()) //  equivalent to the above line

}
