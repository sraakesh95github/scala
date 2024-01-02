package com.rockthejvm

object Basics extends App {
  //defining a value
  //val is a constant - values can't be reassigned
  val meaningOfLife: Int  = 42

  //Int, Boolean, Char, Double, Float, String
  val aBoolean = false

  //strings and string operations
  val aString = "I love Scala"
  val aComposedString = "I" + "Love" + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  //expressions - structures that can be reduced to a value
  //instead of instruction, everything is an expression that cen be reduced
  //to a value
  val anExpression = 2 + 3

  //if-expression
  val ifExpression = if(meaningOfLife > 43) 56 else 999 //No need of ternary operators
  val chainedIfExxpressions = {
    if(meaningOfLife > 43) 56
    else if(meaningOfLife < 0) -2
    else if(meaningOfLife > 999) 78
    else 0
  }

  //code-block
  //Int type is automatically assigned by the compiler
  val aCodeBlock = {
    //definitions
    val aLocalValue = 67

    //last expression of the CodeBlock is the value of the entire block
    aLocalValue + 3
  }

  //functions - Scala is basically a functional programming language
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  //recursive functions
  def factorial(n:Int):Int = {
    if(n<=1) 1
    else n * factorial(n-1)
  }

  /*
  factorial(5) = 5 * factorial(4)
  factorial(4) = 4 * factorial(3)
  factorial(3) = 3 * factorial(2)
  factorial(2) = 2 * factorial(1)
  factorial(1) = 1
   */

  //In Scala we don't use loops or iteration, we use RECURSION!
  //Loops are heavily discouraged in Scala


  //Unit return types
  //Unit - No meaningful value - equivalent of Void
  //type of Side Effects

  def myUnitReturningFunction():Unit = {
    println("I love Scala") //System.out.println, print, printf, consle.log
  }

}
