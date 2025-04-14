package com.elixirin
package lectures.part02OOP

object Ep08AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahaha")
  }

  // Does the following in the background
  /*
    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("abhahahahah")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon$1
  */

  println(funnyAnimal.getClass)


  class Person(name: String) {
    def sayHi: Unit = println(s"Hi mu name is $name! How can I help")
  }

  // Anonymous class works for abstract and non-abstract classes as well
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi mu name is name! How can I help");
  }


}
