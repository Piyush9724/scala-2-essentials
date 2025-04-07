package com.elixirin
package lectures.part01Basics

object Ep06DefaultsAndNamedArguments extends App {
  // Tail Recursive Factorial with default accumulator value
  def tailRecursiveFactorial(n: Int, accumulator: Int = 1): Int = {
    if (n <= 1) accumulator
    else tailRecursiveFactorial(n - 1, n * accumulator)
  }

  // A function for saving a picture with default arguments for format and resolution
  def savePicture(format: String = "JPEG", width: Int = 1920, height: Int = 1080): Unit = {
    println(s"Saving picture in $format format with resolution $width x $height")
  }


  // Example 1: Calling tailRecursiveFactorial with only n, using default accumulator
  println(s"Factorial of 10: ${tailRecursiveFactorial(10)}") // Uses default accumulator = 1

  // Example 2: Calling tailRecursiveFactorial with both n and custom accumulator
  println(s"Factorial of 10 with custom accumulator 2: ${tailRecursiveFactorial(10, 2)}")

  // Example 3: Calling savePicture with all default values
  savePicture() // Uses default values for format (JPEG) and resolution (1920x1080)

  // Example 4: Calling savePicture with custom width and keeping default format and height
  savePicture(width = 1200) // Custom width, default format (JPEG) and height (1080)

  // Example 5: Calling savePicture with custom values for format, width, and height
  savePicture(format = "PNG", width = 800, height = 600) // Custom format and resolution

  // Example 6: Calling savePicture with named parameters in a different order
  savePicture(height = 600, width = 800, format = "BMP") // Custom values, named parameters
}
