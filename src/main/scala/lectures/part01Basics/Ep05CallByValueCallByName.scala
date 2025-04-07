package com.elixirin
package lectures.part01Basics

object Ep05CallByValueCallByName extends App {
  // Function using call-by-value: The argument is evaluated before the function is called.
  def calledByValue(x: Long): Unit = {
    println(s"ByValue: $x")
  }

  // Function using call-by-name: The argument is not evaluated until it is used inside the function.
  def calledByName(x: => Long): Unit = {
    println(s"ByName: $x")
  }

  // Using System.nanoTime to demonstrate the difference
  val time = System.nanoTime()

  // Call-by-value: The expression is evaluated once before passing to the function
  calledByValue(time)

  // Call-by-name: The expression is evaluated every time it's referenced inside the function
  calledByName(time)

  // Demonstrating call-by-name with lazy evaluation in an infinite recursion example
  def infinite: Int = 1 + infinite  // Infinite recursion

  // Print the first parameter (which is a non-recursive value)
  def printFirst(x: Int, y: => Int): Unit = {
    println(x)  // Prints the first argument (x)
  }

  // This works without a stack overflow because `infinite` is not evaluated
  printFirst(34, infinite)  // `infinite` is never evaluated because y is a call-by-name parameter

  // If we reverse the order and try to print the second parameter, it will cause a stack overflow
  // printFirst(infinite, 34)  // Uncommenting this will cause a stack overflow due to the infinite recursion.

  // Example of lazy evaluation with call-by-name parameters
  def lazyEval(x: => Int): Int = {
    println("Before evaluation")
    x  // This will evaluate the argument only when it's needed (when it's referenced here).
  }

  // Call-by-name can help in delaying computation
  lazyEval(2 + 2)  // "Before evaluation" is printed first, then 4 is computed lazily.
}


