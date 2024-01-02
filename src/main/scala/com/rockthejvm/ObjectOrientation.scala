package com.rockthejvm

object ObjectOrientation extends App {
  class Animal {
    val age: Int = 0

    def eat() = println("I'm eating")
  }

  val anAnimal = new Animal

  //Inheritance
  class Dog(val name: String) extends Animal { //Constructor definition

  }

  val aDog = new Dog("Vassie")

  //Constructor arguments are not fields: need to put a val before the constructor argument
  aDog.name

  //subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() //the most derived method will be called at runtime

  //Abstract Class
  abstract class WalkingAnimal {
    protected val hasLegs = true //access modifiers by adding protected or private

    def walk(): Unit // The derived classes should provide an implementation for this class
  }

  //Interface - Ultimate Abstract Class
  trait Carnivore {
    def eat(animal: Animal): Unit //Implementations also accepts implementations
  }

  trait Philosopher {
    def ?!(thought: String): Unit //?! are valid method names
  }

  //Single Class Inheritance
  //Multiple Trait Inheritance
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating you, animal")

    def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  //Scala Method notations and Method Namings
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog //infix notation = object method argument
  //Only available for methods with 1 argument
  aCroc ?! "what if we could fly"

  //operators in scala are methods - Functional Programming Language
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) //equivalent

  //Anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal):Unit = println ("I am a dinosaur and I can eat pretty much anything")
  }

  /*
  This what the compiler interprets this as
  class Carnivore_Anonymous_32134 extends Carnivore {
    override def eat(animal: Animal):Unit println("I am a dinosaur and I can eat pretty much anything")
  }

  val dinosaur = new Carnivore_Anonymous_32134
   */

  //Singleton Object
  object MySingleton //The only Instance of the MySingleton type
  {
    val mySpecialValue = 34421

    def mySpecialMethod(): Int = 34424

    def apply(x: Int): Int = x + 1 //Default method of the Singleton
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65)

  object Animal { //Companions - companion object
    //companions can access each others private fields and methods
    //singleton animal and instances of animals are different
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely //Static Fields and Methods

  //Case Classes
  /*Light weight datastructures with some boilerplate's
  -Sensible equals and hash code
  -Serialization
  -Companion with apply
   */
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 64) // Person.apply("Bob", 64)

  //Exception Handling
  try {
    //code that can throw exceptions
    val x: String = null
    x.length
  } catch { //catch(Exception e) {...}
    case e: Exception => "some faulty error message"
  } finally {
    //Execute from code always
    //Usually used for closing connections and releasing resources
  }

  //Generics
  abstract class MyList[T] {
    def head: T

    def tail: MyList[T]
  }

  //Using a generic with a concrete type
  val aList: List[Int] = List(1, 2, 3) // List.apply(1,2 3)
  val first = aList.head
  val rest = aList.tail

  val aStringList = List("hello", "Scala")
  val firstString = aStringList.head
  val restString = aStringList.tail

  //Point 1: Scala always operates with immutable values
    //No mutations
    /*
  Best for multi-threaded environments
  Makes the code makes more sense
   */
    val reversedList = aList.reverse //returns a new object or list not the reference of the same one like in python

  //Point 2: Scala is closest to the object oriented paradigm
  /*
  All the code bases are part of any object or class
  App is the main class that Scala runs on
  Static main method is already implemented by extending App
   */
}

