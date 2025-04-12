package com.elixirin
package lectures.part02OOP

object Ep02ObjectOrientedBasicsExercises extends App {

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectatios", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.inc.currentCount
  counter.inc.inc.inc.currentCount
  counter.inc(10).currentCount

}

/*
     Novel and a Writer
     Writer: firstName, lastName, year
     -method : fullName


     Novel: name, year of release, author
     -method: authorAge
     -method: isWrittenBy(author)
     - copy (new year of release) - new instance of Novel
  */

class Writer(val firstName: String, val lastName: String, val year:Int ) {
  def getFullName: String = this.firstName + this.lastName
}

class Novel(val name: String, val releaseYear: Int, val author: Writer) {
  def authorAge = releaseYear - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}


/*
     Counter class
     - receives an int value
     - method: current count
     - method:  to increment/decrement => new Counter
     - overLoad inc/dec to receive an amount
*/

class Counter(val count: Int = 0) {
  def inc =  { //immutability
    println("incrementing")
    new Counter(count + 1)
  }
  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int):Counter = {
    if (n <= 0 ) this
    else inc.inc(n -1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n-1)
  }

  def currentCount = println(count)
}

