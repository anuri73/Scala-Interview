# Functional Programming Questions:

### What is pure function?

    > Function without side effect (has no io, doesn't change variables, doesn't communicate with world)
    > For a given set of argument it will always return the same result
    > Referentially transparent (function call could be replaced by result of function)

### Exactly what is a (pure) function?

    A function with input type A and output type B (written in Scala as a single type: A => B) is a computation which relates every value a of type A to exactly one value b of type B such that b is determined solely by the value of a.

### What is side effect?

    > Reassigning a variable
    > Modifying a data structure in place
    > Setting a field on an object
    > Throwing an exception or halting with error
    > Printing to console or reading user input
    > Reading from or writing to a file
    > Drawing the screen

### What does observable mean?

    An effect is anything that can be observed from outside the programs

### How do you understand substitution model?

    When expressions are referentially transparent, we can imagine that computation proceeds very much like we would solve an algebraic equation. We fully expand every part of an expression, replacing all variables with their referents, and then reduce it to its simplest form. At each step we replace a term with an equivalent one; we say that computation proceeds by substituting equals for equals. In other words, RT enables equational reasoning about programs.

### Explain higher order functions.

    Higher order functions take other functions as parameters or return a function as a result. This is possible because functions are first-class values in Scala.

### What is anonymous function?

    In Scala, anonymous function also known as function literal. A function which does not contain name is knonw as an anonymous function.

### What is type parameter?

    It is language cunstruction, that lets you choose the type(s) at the moment of the object's creation

### Explain implicit classes with syntax?

    Implicit classes allow implicit conversations with class's primary constructor when the class is in the scope

### What Is Higher-Kinded Type?

    A higher-kinded type is a type that abstracts over some type that, in turn, abstracts over another type. It’s a way to generically abstract over entities that take type constructors. They allow us to write modules that can work with a wide range of objects. So, we can as well say that it’s a type with a type constructor.

[More about for Higher Kinded Types](help/hkt.md)

### Pros and cons of immutable objects?

    Immutability has several advantages, including (but not limited to):
    - Programs with immutable objects are less complicated to think about, since you don't need to worry about how an object may evolve over time.
    - You don't need to make defensive copies of immutable objects when returning or passing to other functions, since there is no possibility an immutable object will be modified behind your back.
    - One copy of an object is just as good as another, so you can cache objects or re-use the same object multiple times.
    - Immutable objects are good for sharing information between threads in a multi-threaded environment since they don't need to be synchronized.
    - Operations on immutable objects return new immutable objects while operations that cause side-effects on mutable objects usually return void. This means several operations can be chained together. For instance ```("foo" + "bar" + "baz").length()```
    - In languages where functions are first class values, operations like map, reduce, filter, etc. are basic operations on collections. These can be combined in many ways, and can replace most loops in a program.
    **There are of course some disadvantages:**
    - Cyclic data structures such as graphs are difficult to build. If you have two objects which can't be modified after initialization, how can you get them to point to each other?
    - Allocating lots and lots of small objects rather than modifying ones you already have can have a performance impact. Usually the complexity of either the allocator or the garbage collector depends on the number of objects on the heap.
    - Naive implementations of immutable data structures can result in extremely poor performance. For instance, concatenating many immutable strings (like in Java) is O(n2) when the best algorithm is O(n). It is possible to write efficient immutable data structures, it just takes a little more thought.

### What is function currying?

### What are implicit parameters?

### What are type classes?

### What are lenses?

### What is and which are the uses of: Enumerators, Enumerates and Iteratee

### What is a `functor`?

### What is a `applicative`?

### What is a `monad`?

    * #### What are the `monad` axioms?
    * #### What Scala data types are, or behave like, monads?
    * #### What are the basic and optional requirement/s to conform a Monad?
