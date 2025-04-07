package com.elixirin
package lectures.part01Basics

object Ep07StringOperationsAndInterpolations extends App {
  // Basic string declaration
  val str = "Hello, I am learning Scala"

  // 1. Retrieve character at index 2
  println(str.charAt(2))  // Output: L

  // 2. Extract substring from index 7 to 11
  println(str.substring(7, 11))  // Output: I am

  // 3. Split string by space into a list
  println(str.split(" ").toList)  // Output: List(Hello,, I, am, learning, Scala)

  // 4. Check if string starts with "Hello"
  println(str.startsWith("Hello"))  // Output: true

  // 5. Replace spaces with dashes
  println(str.replace(" ", "-"))  // Output: Hello,-I-am-learning-Scala

  // 6. Convert string to lowercase
  println(str.toLowerCase())  // Output: hello, i am learning scala

  // 7. Convert string to uppercase
  println(str.toUpperCase())  // Output: HELLO, I AM LEARNING SCALA

  // 8. Get string length
  println(str.length)  // Output: 26

  // --------------------
  // String Interpolation

  // 9. Using S interpolator for simple variable injection
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old."
  println(greeting)  // Output: Hello, my name is David and I am 12 years old.

  // 10. S interpolator with expressions
  val nextAgeGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old."
  println(nextAgeGreeting)  // Output: Hello, my name is David and I will be turning 13 years old.

  // --------------------
  // 11. Using F interpolator for formatted string
  val speed = 1.2f
  val formattedString = f"$name can eat $speed%2.2f burgers per minute."
  println(formattedString)  // Output: David can eat 1.20 burgers per minute.

  // --------------------
  // 12. Using raw interpolator for literal backslashes
  val path = "C:\\Users\\David\\Documents"
  val rawString = raw"The file is located at $path"
  println(rawString)  // Output: The file is located at C:\Users\David\Documents

  // --------------------
  // Additional String Operations

  // 13. Prepending a character to a string
  val numberString = "45"
  println('a' + ":" + numberString)  // Output: a:45

  // 14. Appending a character to a string
  println(numberString + ":z")  // Output: 45:z

  // 15. Reversing the string
  println(str.reverse)  // Output: alacS gninrael ma I ,olleH

  // 16. Take the first two characters of a string
  println(str.take(2))  // Output: He
}
