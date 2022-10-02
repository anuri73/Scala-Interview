# Fun Questions:

### Is there any difference between functions and methods in Scala?

A Scala method, as in Java, is a part of a class. It has a name, a signature, optionally some annotations, and some
bytecode.

When we define function literal, what is actually being defined is an object with method called apply. Scala has a
special rule for this method name, so that objects that have an apply method can be called as if they were themselves
methods. When we define a function literal like (a, b) => a < b this is really syntax sugar for object creation:

```scala
val lessThan = new Function2[Int, Int, Boolean] {
  def apply(a: Int, b: Int) = a < b
}
```

That is why functions has AnyRef additional methods that method does not(toString)

Also, methods could be parametrized, while function can not

```scala
def m2[T](x:T) = x.toString.substring(0,4)
```

We could call method as function:

```scala
class test {
  def m1(x: Int) = x + 3 // method

  val f1 = (x: Int) => x + 3 // function
  val f2 = m1 _ // function
}

```

### What's a cool project that you've recently worked on?

### What testing framework for Scala do you use?

### What do you know about property based testing frameworks, such as Scalacheck?

### Do you like ‘scalaz‘?