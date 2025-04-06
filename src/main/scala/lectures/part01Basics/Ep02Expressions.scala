package com.elixirin
package lectures.part01Basics

object Ep02Expressions extends App {
  // Basic expression
  val x = 1 + 2
  println(x) // 3

  // Mathematical expression
  println(2 + 3 * 4) // 14 (Multiplication has higher precedence)

  // Bitwise operators
  val bitwiseAnd = 1 & 3
  val bitwiseOr = 1 | 3
  val bitwiseXor = 1 ^ 3
  val leftShift = 1 << 2
  val rightShift = 8 >> 2
  val unsignedRightShift = 8 >>> 2

  // Relational expressions
  println(1 == x) // false
  println(1 != x) // true
  println(1 < x)  // true
  println(1 <= x) // true
  println(1 > x)  // false
  println(1 >= x) // false

  // Boolean logic
  println(!(1 == x)) // true
  println((x == 3) && (x < 4)) // true
  println((x == 3) || (x > 4)) // true

  // Side effects: variable reassignment
  var aVariable = 2
  aVariable += 3 // aVariable becomes 5
  println(aVariable)

  // Instructions vs Expressions
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3
  println(aConditionedValue) // 5

  println(if (aCondition) 5 else 3) // 5

  // Discouraged: While loop (Imperative)
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // Side effects return Unit
  val aWeirdValue = {
    aVariable = 3
  }
  println(aWeirdValue) // ()

  val aWhile = while (i < 1) {
    println("still looping")
    i += 1
  }
  println(aWhile) // ()

  // Code block as expression
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
  println(aCodeBlock) // "hello"

  // Code block exercises
  val someValue = {
    2 < 3
  }
  println(someValue) // true

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  println(someOtherValue) // 42
}
