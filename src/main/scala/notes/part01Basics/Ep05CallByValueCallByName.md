# Understanding Call by Value and Call by Name in Scala

This guide explores the fundamental differences between calling functions by value and by name in Scala. Two functions are defined: `calledByValue` and `calledByName`. The former computes the parameter value before the function executes, using it consistently throughout. The latter passes the expression directly, evaluating it each time it is referenced within the function.

## Key Concepts and Code Examples

### 📚 **By Value vs. By Name**
The core difference between calling by value and calling by name lies in when the parameter expression is evaluated:

- **Call by Value**: The parameter is evaluated before the function call, and the evaluated value is used consistently throughout the function.

- **Call by Name**: The parameter is not evaluated until it is used within the function. Each reference to the parameter results in re-evaluating the expression.

### Example:
```scala
def calledByValue(x: Long): Unit = {
  println(s"ByValue: $x")
}

def calledByName(x: => Long): Unit = {
  println(s"ByName: $x")
}

val time = System.nanoTime()

calledByValue(time)  // Evaluates `time` once before passing to the function
calledByName(time)   // Evaluates `time` every time it's referenced inside the function
```

### ⏱️ **`System.nanoTime` Example**
The `System.nanoTime` function returns the current time in nanoseconds. The difference in evaluation strategies becomes evident when this expression is passed to both `calledByValue` and `calledByName` functions.

- In **call by value**, the expression is evaluated before the function is executed, meaning the same value is used inside the function.
- In **call by name**, the expression is evaluated each time it is used, resulting in different outputs even if the same expression is passed.

### Example:
```scala
def calledByValue(x: Long): Unit = {
  println(s"ByValue: $x")
}

def calledByName(x: => Long): Unit = {
  println(s"ByName: $x")
}

val time = System.nanoTime()

calledByValue(time)  // Same time value used
calledByName(time)   // Different time value due to re-evaluation
```

### 🧩 **Parameter Types**
The use of the `long` type for the parameter in both functions is important for compatibility with time functions in JVM. The type ensures that the passed expression works with functions that return `Long` values, such as `System.nanoTime`.

### 🔄 **Infinite Recursion Example**
Call by name proves useful in handling expressions that could potentially cause infinite recursion. By delaying the evaluation of recursive expressions until absolutely necessary, stack overflow errors can be prevented.

### Example:
```scala
def infinite: Int = 1 + infinite

def printFirst(x: Int, y: => Int): Unit = {
  println(x)
}

printFirst(34, infinite)  // Avoids stack overflow by not evaluating `infinite`
```

In this example, `printFirst` does not evaluate `infinite` because the second parameter is passed by name. The recursive call is never triggered.

### 📉 **Lazy Evaluation Uses**
The call by name mechanism is widely used in lazy evaluation scenarios, such as lazy streams or data structures. It defers the computation until the value is needed, which can improve performance in cases where computation is expensive or unnecessary.

### ❗ **Function Behavior Understanding**
Understanding how parameters are passed and evaluated in Scala is critical for writing efficient and predictable programs. Call by value may result in repeated evaluations of the same expression, while call by name avoids this by deferring evaluation.

### 🎓 **Learning Resource**
This video serves as an entry point to deeper explorations of Scala’s feature set. Further studies could cover more advanced topics related to function calls and memory management in functional programming.

## Key Insights

- 🔄 **Call by Value Mechanism**:
  In call by value, the expression is evaluated before the function call, and the evaluated value is used consistently throughout. This mechanism is simple and often found in other languages. It can be less efficient if the same expression is recalculated multiple times.

  ### Example:
  ```scala
  def callByValue(x: Int): Unit = {
    println(x)
  }

  val result = 2 + 2
  callByValue(result)  // `result` is evaluated once before being passed
  ```

- 📍 **Call by Name Mechanism**:
  With call by name, the expression is not evaluated until it is used inside the function. This can help in scenarios where evaluation needs to be delayed or where recursion could otherwise lead to a stack overflow.

  ### Example:
  ```scala
  def callByName(x: => Int): Unit = {
    println(x)
  }

  callByName(2 + 2)  // `2 + 2` is evaluated every time it's referenced
  ```

- 🚀 **Performance Implications**:
  The performance impact of evaluation strategies can be significant. Call by name can be beneficial for optimizing code by avoiding unnecessary recalculations of expensive expressions.

- 🌐 **Utility in Data Structures**:
  Call by name plays a key role in functional programming, especially in the implementation of lazy data structures like lazy lists or infinite streams. It allows for efficient handling of computations that don't need to be evaluated immediately.

- 🧭 **Stack Overflow Prevention**:
  By delaying evaluation, call by name helps prevent stack overflow errors when dealing with recursive expressions that would otherwise result in infinite recursion.

- 📊 **Debugging and Testing**:
  A solid understanding of call by value and call by name is crucial for debugging and testing. Misunderstanding function evaluation can lead to unexpected results, especially in cases of lazy evaluation or recursion.