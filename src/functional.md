# Functional Programming Questions:

* ### Explain implicit classes with syntax?

> Implicit classes allow implicit conversations with class's primary constructor when the class is in the scope

* ### What Is Higher-Kinded Type?

> A higher-kinded type is a type that abstracts over some type that, in turn, abstracts over another type. It’s a way to generically abstract over entities that take type constructors. They allow us to write modules that can work with a wide range of objects. So, we can as well say that it’s a type with a type constructor.

[More about for Higher Kinded Types](help/hkt.md)

* ### Explain higher order functions.

> Higher order functions take other functions as parameters or return a function as a result. This is possible because functions are first-class values in Scala.

* ### What is gained from using immutable objects?
* ### What is tail recursion?
    * #### How does it differentiate from common recursion?
  > A recursive function is said to be tail recursive if the recursive call is the last thing done by the function. There is no need to keep record of the previous state.
    * #### How does the Scala compiler optimize a tail recursive function?
  > In tail recursive methods, all the computations are done before the recursive call, and the last statement is the recursive call. Compilers can then take advantage of this property to avoid stack overflow errors, since tail recursive calls can be optimized by not inserting info into the stack.

Example:

```scala
def sum(n: Int): Int = { // computes the sum of the first n natural numbers
  if (n == 0) {
    n
  } else {
    n + sum(n - 1)
  }
}

@scala.annotation.tailrec
def tailSum(n: Int, acc: Int = 0): Int = {
  if (n == 0) {
    acc
  } else {
    tailSum(n - 1, acc + n)
  }
}
```

If we run both versions the following computations will be executed:

```bash
> sum(5)
sum(5)
5 + sum(4) // computation on hold => needs to add info into the stack
5 + (4 + sum(3))
5 + (4 + (3 + sum(2)))
5 + (4 + (3 + (2 + sum(1))))
5 + (4 + (3 + (2 + 1)))
15

tailSum(5) // tailSum(5, 0) because the default value
tailSum(4, 5) // no computations on hold
tailSum(3, 9)
tailSum(2, 12)
tailSum(1, 14)
tailSum(0, 15)
15
```

* ### What is function currying?
* ### What are implicit parameters?
* ### What are typeclasses?
* ### What are lenses?
* ### What is and which are the uses of: Enumerators, Enumeratees and Iteratee
* ### What is a `functor`?
* ### What is a `applicative`?
* ### What is a `monad`?
    * #### What are the `monad` axioms?
    * #### What Scala data types are, or behave like, monads?
    * #### What are the basic and optional requirement/s to conform a Monad?