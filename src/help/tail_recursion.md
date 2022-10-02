### What is tail recursion?
#### How does it differentiate from common recursion?
    A recursive function is said to be tail recursive if the recursive call is the last thing done by the function. There is no need to keep record of the previous state.
#### How does the Scala compiler optimize a tail recursive function?
    In tail recursive methods, all the computations are done before the recursive call, and the last statement is the recursive call. Compilers can then take advantage of this property to avoid stack overflow errors, since tail recursive calls can be optimized by not inserting info into the stack.
#### How does @scala.annotation.tailrec work?
    In Scala 2.8, you will also be able to use the new @tailrec annotation to get information about which methods are optimised.
    This annotation lets you mark specific methods that you hope the compiler will optimise.
    You will then get a warning if they are not optimised by the compiler.
    In Scala 2.7 or earlier, you will need to rely on manual testing, or inspection of the bytecode, to work out whether a method has been optimised.


Example:

```scala
// computes the sum of the first n natural numbers
def sum(n: Int): Int = {
  if (n == 0) 0
  else {
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