# Scala Job Interview Questions

This file contains a number of Scala interview questions with answers that can be used when vetting potential candidates or preparing for the Scala position interview.

## Table of Contents

  1. [General Questions](#general-questions)
  1. [Language Questions](#language-questions)
  1. [Functional Programming Questions](#functional-programming-questions)
  1. [Reactive Programming Questions](#reactive-programming-questions)
  1. [Coding Questions](#coding-questions)
  1. [Fun Questions](#fun-questions)

#### General Questions:

1.1 What did you learn yesterday/this week?
  > As far as I know myself, I always try to learn something new and evlolve in my professional career. Not only because of the specifics of our specialty (technologies are improving by leaps and bounds), but also because I like to learn and explore the world. Answering your question, I have been actively studying Apache Spark technology for the last month - what it is needed for and in what situations it can be useful.

1.2 Why and how did you start learning Scala?
  > I first heard about the scala in an article about machine learning, around January 2021. And I became so interested in it that I decided to try to study it. Since then, I have fallen in love with this language every day:
  - In it's ability to write code in both OOP style and functional style.
  - In it's vision and rich set of collections.
  - In it's pattern matching.
  - In it's call by name arguments and lazy vals
  - In it's case classes
  - In it's immutable objects
  - In it's concurrency control
  - In it's higher order functions
And I strongly believe this list will be infinite as much as I will learn this technology. Because every part of language is thought out well.

1.3 What excites or interests you about coding in Scala?
  - In it's ability to write code in both OOP style and functional style.
  - In it's vision and rich set of collections.
  - In it's pattern matching.
  - In it's call by name arguments and lazy vals
  - In it's case classes
  - In it's immutable objects
  - In it's concurrency control
  - In it's higher order functions

1.4 What is a recent technical challenge you experienced and how did you solve it?
  > The most important challenge for me now is switching from PHP to Scala. It's hard, but at the same time very exciting, because I have to re-learn everything from stratch. Think about progragmming from another side, another point of view. I am talking about functional programming, concurency, JVM, memory allocation.

1.5 Talk about your preferred development environment. (OS, Editor or IDE, Tools, etc.)
  > Ubuntu, Intellij Idea / Visual Studio Code

1.6 What are your thoughts about the other JVM languages compared to Scala?
  > I am not yet confident enough to discuss about it, because I have not compared them yet. But, I heard that Scala is Java with Sugar. And there is also already very know language called Kotlin, but now I devote all of myself to Scala. Maybe in future..

1.7 Do you think that the Scala language and community is mature enough?
  > Yes, for sure. There are already a lot of tools like Apache Spark, Apache Kafka, Akka framework written in Scala language. A lot of library were written to develop enterprise projects. There are also a lot people in community who could help you. I believe this community will be raised by time.

#### Language Questions:

* What is the difference between a `var`, a `val` and `def`?
  > In short, the val and var are evaluated when defined, while def is evaluated on call. Also, val defines a constant, a fixed value that cannot be modified once declared and assigned while var defines a variable, which can be modified or reassigned.

* What is the difference between a `trait` and an `abstract class`?

**Traits**|**Abstract Class**
:-----:|:-----:
Traits support multiple inheritance.|Abstract class does not support multiple inheritance.
We are allowed to add a trait to an object instance.|We are not allowed to add an abstract class to an object instance.
Traits does not contain constructor parameters.|Abstract class contain constructor parameters.
Traits are completely interoperable only when they do not contain any implementation code.|Abstract class are completely interoperable with Java code.
Traits are stackable. So, super calls are dynamically bound.|Abstract class is not stackable. So, super calls are statically bound.

* What is the difference between an `object` and a `class`?
  > An `Object` is a class that has exactly one instance.
  > Classes in Scala are blueprints for creating objects.

* What is `companion objects`?
  > An object with the same name as a class is called a companion object. 
  
* What is a `case class`?  
    - Case classes can be pattern matched
    - Case classes automatically define hashcode and equals
    - Case classes automatically define getter methods for the constructor arguments.

* What is the difference between a Java future and a Scala future?
The main inconvenience of `java.util.concurrent.Future` is the fact that you can't get the value without blocking.
In fact, the only way to retrieve a value is the get method, that ([quoting from the docs](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Future.html))
`Waits if necessary for the computation to complete, and then retrieves its result.`
With `scala.concurrent.Future` you get instead a real non-blocking computation, as you can attach callbacks for completion (success/failure) or simply map over it and chain multiple Futures together in a monadic fashion.
Long story short, scala's Future allows for asynchronous computation without blocking more threads than necessary.

* What is the difference between `unapply` and `apply`, when would you use them?
  > when you treat your object like a function, apply is the method that is called
  > `unaply` deconstructs an instance of class, and is the foundation of pattern matching
* What is a companion object?
* What is the difference between the following terms and types in Scala: `Nil`, `Null`, `None`, `Nothing`?
* What is `Unit`?
* What is the difference between a `call-by-value` and `call-by-name` parameter? 
	* How does Scala's `Stream` trait levarages `call-by-name`?
* Define uses for the `Option` monad and good practices it provides.
* How does `yield` work?
* Explain the implicit parameter precedence.
* What operations is a `for comprehension` syntactic sugar for?
* Streams:
	* What consideration you need to have when you use Scala's `Streams`? 
	* What technique does the Scala's `Streams` use internally?

#### Functional Programming Questions:

* What is a `functor`?
* What is a `applicative`?
* What is a `monad`?
  * What are the `monad` axioms?
  * What Scala data types are, or behave like, monads?
  * What are the basic and optional requirement/s to conform a Monad?
* Explain higher order functions.
* What is gained from using immutable objects?
* What is tail recursion?
  * How does it differentiate from common recursion?
  * What issues are there with tail recursive functions in the JVM?
  * How does the Scala compiler optimize a tail recursive function?
  * How do you ensure that the compiler optimizes the tail recursive function?
* What is function currying?
* What are implicit parameters?
* What are typeclasses?
* What are lenses?
* What is and which are the uses of: Enumerators, Enumeratees and Iteratee

#### Reactive Programming Questions:

* Explain the actor model.
* What are benefits of non-blocking (asynchronous I/O) over blocking (synchronous I/O).
* Do you think that Scala has the same async spirit as Node.js?
* Explain the difference between `concurrency` and `parallelism`, and name some constructs you can use in Scala to leverage both.
* What is the global ExecutionContext?
  * What does the global ExecutionContext underlay?
* Akka:
	* Which are the 3 main components in a Stream?

#### Coding Questions:

* How can you make a `List[String]` from a `List[List[String]]`?
* What is the difference (if any) between these 2 statements? 
```scala
  var x = immutable.Set[Int]()
  val y = mutable.Set[Int]()
```

#### Fun Questions:

* What's a cool project that you've recently worked on?
* What testing framework for Scala do you use?
* What do you know about property based testing frameworks, such as Scalacheck?
* Do you like ‘scalaz‘?


