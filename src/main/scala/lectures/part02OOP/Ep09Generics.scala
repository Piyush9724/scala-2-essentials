package com.elixirin
package lectures.part02OOP

object Ep09Generics extends App {
  // Generic type A
  class MyList[A] {
    // use the type A
  }

  // Generic type of Key and Value
  class MyMap[Key, Value]

  //traits can also be parameterised

  val listOfIntegers = new MyList[Int]
  val listOfStrings =  new MyList[String]


  // generic methods
  object MyList {
    // method signature type parameterised with generic type parameter
    def empty[T]: MyList[T] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]


  // The Variance Problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  // Questions is, if Cat extends Animal, does a list of Cats also extends List of Animals
  // Answer 1. YES List[Cat] extends List[Animal]          =  called as COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? <- this is a HARD QUESTION
  // we return a List[Animal]


  // Answer 2. NO List[Cat] and List[Animal] are two separate things  called as InvariantList
  // INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
  /*
    val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] Type mismatch.
    Required: InvariantList [ Animal ]
    Found:
    InvariantList [ Cat ]
  */

  // Answer 3. Hell, No ! CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
  // the above doesn't make sense because Cat is a subtype of Animal ( and Animal can be dog too)

  // But the Covariance can be understood with this following example
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]
  /*
   Now the semantics of the above line changed totally
   The Trainer of Animal can train a Cat, Dog or any other Animal
   So we can use Trainer of Animal to train cat to be more particular
  */


  // Bounded Types
  // allows us to use generic classes only for certain classes that are either sub class of a different type or a super class of a different type
  class Cage[A <: Animal] (animal: A)
  // here we say class Cage only accepts type parameter of A which are subtypes of Animals  ( Example of Upper Bounded Types )
  // class Cage[A >: Animal] (Example of Lower Bounded Types = cage accepts type parameter which are super types of class Animal )
  val cage = new Cage(new Dog)

  //class Car
  // val newCage = new Cage(new Car)
  // the above line will give the compile error
  /*
      inferred type arguments [com.elixirin.lectures.part02OOP.Ep09Generics.Car] do not conform to value <local Cage>'s type parameter bounds [A <: com.elixirin.lectures.part02OOP.Ep09Generics.Animal]
      val newCage = new Cage(new Car)
  */


  // IMP : Bounded Types solves a variance problem which is very annoying when we want to write covariant collections
  // Suppose we have a list MyCovariantList
  class MyCovariantList[+A] {
    // def add(element: A): MyCovariantList[A] = ???
    /* the above gives a compile error Covariant type A occurs in contravariant position in type A of value element
       even though the MyCovariantList is generic and Covariant (using[+A])
       This Error is a technical version of the HARD Questions is, if Cat extends Animal, does a list of Cats also extends List of Animals
       If we want to define a covariant list we need to be able to answer the HARD Question
       If I have a list of Animals which in fact is a List of Cat, What if I add a dog to it
       Answer: if to a list of Cats I add a dog, that will turn this list into a List of Animal ( which is more generic class : Animal )
       Technical Answer to write is the following definition of the add method
    */
    def add[B >: A](element: B): MyCovariantList[B] = ???
    // Says if to a List of A, if we put in a B (which is a super type of A) than this list will turn into List[B] not List[A]

    /*
     A = Cat
     B = Animal
    */
  }



}
