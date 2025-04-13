package com.elixirin
package lectures.part02OOP

object Ep07AbstractDataTypes extends App {
  // abstract
  abstract class Animal {
    val creatureType: String = s"wild"
    def eat: Unit
  }

  // Abstract classes cannot be instantiated
  // val animal = new Animal

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
    // can override abstract methods without the override keyword too
    // def eat: Unit = println("crunch crunch")
  }


  // traits
  trait Carnivore {

    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    override def eat(animal: Animal): Unit = println(s"I am a crocodile and I am eating ${animal.creatureType}")
    override def eat: Unit = println(s"nom nom")
  }


  val dog = new Dog
  val croc = new Crocodile
  croc eat dog

  // traits vs abstract
  // 1. traits do not have constructor parameters
  // 2. Multiple Traits can be inherited by the same class
  // 3. traits are behaviour, abstract class is a type of String

}
