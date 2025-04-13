package com.elixirin
package lectures.part02OOP

import scala.language.postfixOps

object Ep05Objects extends App {
  // SCALA DOES NOT HAVE CLASS_LEVEL FUNCTIONALITY ("static")
  // TO USE CLASS_LEVEL FUNCTIONALITY WE USE OBJECTS IN SCALA


  // Scala Object is a SINGLETON INSTANCE
  // Person is a type and its only instance
  object Person {
    // "static"/"class" level FUNCTIONALITY
    // An Object can have val, var and method defs
    // Objects cannot receive parameters
    val N_EYES = 2
    def canFly: Boolean = false

    // factory methods
    //def from(mother: Person, father: Person): Person = new Person("Bobbie")
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person (val name: String) {
    // instance-level FUNCTIONALITY
  }
  // This pattern to write classes and objects with the same name is called COMPANIONS
  // With this approach Scala is more object Oriented Language than JAVA even though it was designed as a Functional Language

  println(Person.N_EYES)

  // object = SINGLETON INSTANCE
  val mary = Person
  println(mary.canFly)

  val john = Person
  println(mary == john)
  //mary and john point to the same instance and therefore will return true

  val mary2 = new Person("Mary")
  val john2 = new Person("John")
  println(mary2 == john2)
  // mary2 and john2 will not be same as they refer to different instances therefore will print false


  // WHAT WE MEANT WHEN WE SAY OBJECT PERSON IS SINGLETON IS
  val person1 = Person
  val person2 = Person
  println(person1 == person2) // this prints true

  // val bobbie = Person.from(mary2, john2)
  // the factory methods can be called conveniently called using apply method
  val bobbie = Person.apply(mary2, john2)
  // also we can omit the "apply" here and this can be called as and looks like a constructor call (notice here the new keyword is missing though)
  val bobbie1 = Person(mary2, john2)


  // Scala Applications = Scala Object with
  // def main(args: Array[String]): Unit


}
