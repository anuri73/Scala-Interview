import scala.annotation.tailrec

object AbsModule {
  def abs(n: Int): Int =
    if (n < 0) -n
    else n
  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }
  def main(args: Array[String]): Unit =
    println(formatAbs(-42))
}

object FactorialModule {
  def factorial(n: Int): Int = {
    @tailrec
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n - 1, n * acc)
    go(n, 1)
  }
}

object FibonachiModule {
  def fib(n: Int): Int = {
    @annotation.tailrec
    def go(index: Int, prev: Int, current: Int): Int = {
      if (index <= 0)
        current
      else
        go(index - 1, prev = prev + current, prev)
    }

    go(n, 1, 0)
  }
}

def formatResult(name: String, n: Int, f: Int => Int): String = {
  val message = "The %s of %d is %d"
  message.format(name, n, f(n))
}

formatResult("absolute value", -42, AbsModule.abs)
formatResult("factorial", 7, FactorialModule.factorial)
