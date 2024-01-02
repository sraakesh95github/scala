package com.rockthejvm

object PatternMatching extends App {

  //----------SWITCH STATEMENTS----------
  //Pattern matching is an expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  println(order)

  case class Person(name: String, age: Int)
  val bob = Person("Bob", 43)
  /*
    Case classes need not be instantiated with the keyword new
    They are accompanied by a companion apply method - Person.apply("Bob", 43)
   */


  //----------PM IN CASE CLASSES----------
  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "Something else"
  }
  println(personGreeting)
  //One of the benefits of case classes is to deconstruct the elements for pattern matching

  //----------TUPLE DECONSTRUCTION----------
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to $genre"
    case _ => "I dunno what you are talking about"
  }
  println(aTuple)

  //----------LIST----------
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_, 2, _) => "List containing 2 on it's second position"
    case _ => "unkown list"
  }
  println(listDescription)

  //----------ALL CASES IN SEQUENEC----------
  val aList2 = List(1, 2, 3)
  val list2Description = aList2 match {
    case _ => "unknown list"
    case List(_, 2, _) => "List containing 2 on it's second position"
  }
  println(list2Description)
}
