package com.elixirin
package lectures.part01Basics

import scala.annotation.tailrec

object Ep04Recursion extends App {
  // Simple recursive factorial function
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  // Tail-recursive factorial using an accumulator
  def factorialTailRec(n: Int): BigInt = {
    @tailrec
    def helper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else helper(x - 1, x * accumulator)
    }
    helper(n, 1)
  }

  // Tail-recursive string concatenation
  def concatenateTailRec(str: String, n: Int): String = {
    @tailrec
    def helper(x: Int, accumulator: String): String = {
      if (x <= 0) accumulator
      else helper(x - 1, accumulator + str)
    }
    helper(n, "")
  }

  // Tail-recursive prime checking
  def isPrime(n: Int): Boolean = {
    @tailrec
    def helper(divisor: Int): Boolean = {
      if (divisor <= 1) true
      else if (n % divisor == 0) false
      else helper(divisor - 1)
    }
    if (n <= 1) false else helper(n / 2)
  }

  // Tail-recursive Fibonacci calculation
  def fibonacci(n: Int): Int = {
    @tailrec
    def helper(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else helper(i + 1, last + nextToLast, last)
    }
    if (n <= 2) 1 else helper(2, 1, 1)
  }


  println("Factorial of 5 (standard): " + factorial(5))
  println("Factorial of 5000 (tail-recursive): " + factorialTailRec(5000))
  println("Concatenate 'abc' 3 times: " + concatenateTailRec("abc", 3))
  println("Is 29 prime? " + isPrime(29))
  println("10th Fibonacci number: " + fibonacci(10))
}
