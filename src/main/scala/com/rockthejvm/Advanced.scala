package com.rockthejvm

import scala.util.{Try, Failure, Success}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global //Lets the Execution context not be given at multi-threading

object Advanced extends App {

  //----------LAZY EVAL----------
  lazy val aLazyVal = 2
  lazy val lazyValueWithSideEffect = { //code-block
    println("I am so very lazy!")
    43
  }

  val eagerVal = lazyValueWithSideEffect + 1 //useful in inifinite collections

  //----------PSEUDO COLLECTIONS [OPTION, TRY]----------
  def methodWhichCanReturnNull(): String = "hello, scala"
  val anOption = Option(methodWhichCanReturnNull()) //Some("hello, scala")
  //Option - A Collection which contains atmost 1 element: Some(value) or None

  //----------OPTION----------

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string" //Some is the subtype of the option abstract type
    case None => "I obtained nothing"
  }
  //map, flatmap, filter
  //When using options, no need to explicitly check for nulls

  //----------TRY----------
  def methodWhichCanThrowException(): String = throw new RuntimeException() //Bad for JVM or Scala programs
  val aTry = Try(methodWhichCanThrowException())
  //a Try is a collection with either a value if the code went well or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(ex) => s"I hav obtained an exception: $ex"
  }
  /*
  try {
    methodWhichCanThrowException()
  } catch {
    case e: Exception => "Defend against this evil exception"
  }*/

  //----------ASYNCHRONOUS PROGRAMMING (MULTI-THREADING)----------
  val aFuture = Future{
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  }
  //The Future is a collection which can contain a value when it is evaluated. Until then, there are no values
  //The FUTURE is composable with map, flatMap and filter

  //----------MONADS----------

  //----------IMPLICITS----------
  //Usecase 1: Implicit Arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs) //aMethodWithImplicitArgs(myImplicitInt)

  //Usecase 2: Implicit Conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n%2 == 0
  }
  println(23.isEven()) // new MyRichInteger(23).isEven() - Dangerous in terms of processing and compute

  Thread.sleep(2000)
}
