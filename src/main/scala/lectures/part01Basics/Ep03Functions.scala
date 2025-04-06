package com.elixirin
package lectures.part01Basics

object Ep03Functions {

  // 1. Basic function definition and call
  def aFunction(): Int = 42

  // 2. Parameterized function with string concatenation
  def aParameterizedFunction(a: String, b: Int): String = a + " " + b

  // 3. Function with side effects (Unit return type)
  def aFunctionWithSideEffects(): Unit = println("Hello, Scala!")

  // 4. Nested (auxiliary) function for greeting
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  // 5. Function that returns Unit, showing side effect
  def aVoidFunction(): Unit = {
    println("I just performed a side effect!")
  }

  // 6. Function to compute factorial recursively
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  // 7. Function to compute Fibonacci numbers recursively
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  // 8. Function to check for prime numbers using an auxiliary function
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(n / 2)
  }

  // Main function to test the above
  def main(args: Array[String]): Unit = {
    println(aFunction())
    println(aParameterizedFunction("Scala number", 42))
    aFunctionWithSideEffects()
    println(aRepeatedFunction("hello", 3))
    aVoidFunction()
    println("Factorial of 5: " + factorial(5))
    println("Fibonacci of 7: " + fibonacci(7))
    println("Is 29 prime? " + isPrime(29))
  }
}
