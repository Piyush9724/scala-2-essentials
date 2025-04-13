package com.elixirin
package lectures.part02OOP

object Ep06Inheritance extends App {
  // SINGLE CLASS INHERITANCE
  //sealed class Animal { // sealed
  class Animal {
    val creatureType: String = "Wild"
    def eat: Unit = println("nomnomnom")
    //final def eat: Unit = println("nomnomnom")

  }

  class Cat extends Animal {
    def crunch: Unit = {
      eat
      println("crunch crunch")
    }
  }


  val cat = new Cat
  //cat.eat
  cat.crunch


  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  // Correct way to extend a class with parameters
  class Adult(name: String, age: Int, idCard: String ) extends Person(name, age)
  // if you have an auxiliary constructor we can extend it in the following way
  // class Adult(name: String, age: Int, idCard: String ) extends Person(name)

  // Overriding


  class Dog(override val creatureType: String) extends Animal {
    // override val creatureType = "Domestic"
    // Notice we can also override fields of Super Class in the constructor of the child class
    override def eat = {
      // super
      super.eat
      println("wow wow")
    }
  }

  val dog = new Dog("Domestic")
  dog.eat
  println(dog.creatureType)

  // type Substitution (broadly called Polymorphism
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overriding vs overloading (understand this on own)

  // preventing overrides
  // 1. keyword final on method
  // 2. keyword final on class
  // 3. seal the class = extend classes in THIS FILE, but prevent extensions in other files

}
