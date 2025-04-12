package com.elixirin
package lectures.part02OOP

object Eo04MethodNotationsExercises extends App {
  class Person (val name: String, val favoriteMovie: String, val age: Int ) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} and ${person.name}" // Flexibility to name method as +
    def unary_! : String = s"$name What the heck"
    def isAlive: Boolean = true // Functions that do not use any parameter can be used with postfix notation
    def apply(): String = s"Hi my name is $name I am $age years old and my favorite movie is $favoriteMovie"
    def +(nickName: String): Person =  new Person(s"$name ($nickName)", favoriteMovie, age)
    def unary_+ : Person = new Person(name, favoriteMovie, age+1)
    def learns(subject: String) = s"$name learns $subject"
    def apply(count: Int): String = s"$name watched $favoriteMovie $count times"
  }
  /*
    1. Overload the + operator
       mary + "the rockstar" => new person "Mary (the rockstar)"
    2. Add an age to the Person class
       Add a unary + operator => new person with the age + 1 +mary => mary with the age incrementer
    3. Add a "learns" method in the Person class => "Mary learns Scala"
       Add a learnsScala method, calls learns method with "Scala" Use it in postfix notation.
    4. Overload the apply method
       mary.apply (2) => "Mary watched Inception 2 times"
   */


  val mary = new Person("Mary", "Inception", 24)
  println(mary likes "Inception")

  println((mary + "the RockStar")())

  println((+mary)())

  println(((+mary) + "the RockStar" )())

  println(mary learns "scala")

  println(mary (2))


}
