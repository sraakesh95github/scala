package com.rockthejvm

import java.awt.Paint

object FunctionalProgramming extends App {
  //Scala is Object Oriented
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43)
  /*
  Scala runs on JVM
  Functional Programming: First Class elements of programming
    - compose functions
    - pass functions as args
    -return functions as results

   Conclusion: FunctionX = Function1, Funciton2, ....,Function22)
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) //24
  simpleIncrementer(23) //simpleIncrementer.apply(23)
  //defined a function!

  //ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  val stringConcatenator = new Function2[String,String,String] {
    override def apply(arg1: String, arg2: String):String = arg1 + arg2
  }
  stringConcatenator("I love", "Scala")

  //2. Syntax Sugars
  /*
  Equivalent to the below code:

  new Function1[Int, Int] {
    override def apply(x: Int) = 2 * x
  }
   */
  val doubler: Function1[Int, Int] = (x:Int) => 2 * x
  val tripler = (x: Int) => x*3
  doubler(4) //8
  tripler(6) //18

  //----------HIGHER ORDER FUNCTIONS (HOF)----------
  val aMappedList:List[Int] = List(1,2,3).map(x => x + 1) //Map is a higher order function
  println(aMappedList) //Another List or instance of List is returned

  //----------FLAT MAP----------
  val aFlatMappedList = List(1,2,3).flatMap(x => List(x, x*2))
  println(aFlatMappedList) //Often used
  val anotherFlatMap = List(1,2,3).flatMap {
    x => List(x, x*2)
  } //Alternative syntax for flatmap
  println(anotherFlatMap)

  //----------FILTER----------
  val aFilteredList = List(1,2,3,4,5).filter(x => x <= 3)
  println(aFilteredList)
  //Alternative Syntax
  val anotherFilteredList =List(1,2,3,4,5).filter(_ <= 3)
  println(anotherFilteredList)
  //All the pairs between 1,2,3 and the letters 'a', 'b', 'c'
  val allPairs = List(1,2,3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  println(allPairs)

  //----------FOR COMPREHENSIONS----------
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  }  yield s"$number-$letter"
  //equivalent to the map / flatmap chain above
  println(alternativePairs)

  //----------COLLECTIONS----------
  val aList = List(1,2,3,4,5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0::aList //List(0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6 //List(0,1,2,3,4,5)
  //+: prepends an element to a list
  //:+ appends an element to a list

  //----------SEQUENCES----------
  val aSequence: Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3)
  val accessedElement = aSequence(1) //returns the element at index 1 of the sequence i.e 2

  //----------VECTORS----------
  val aVector = Vector(1,2,3,4,5,6)
  //Fast access times compared to sequences

  //----------SETS----------
  val aSet = Set(1,2,3,3,4,4,5) //Set(1,2,3,4,5)
  val setHas5 = aSet.contains(5) //false
  val anAddedSet =  aSet + 6 //Set(1,2,3,4,5,6)
  val aRemovedSet = aSet - 3 //Set(1,2,4,5)

  //----------RANGES----------
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(2*_).toList //List(2,4,6,8,...,2000)

  //----------TUPLES----------
  //Tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  //----------MAPS----------
  val aMap: Map[String, Int] = Map(
    ("Daniel", 31321),
    ("Jane", 432424),
    "Austin" -> 43245
  )
}
