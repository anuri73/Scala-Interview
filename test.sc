import scala.annotation.tailrec

def binarySearch[@specialized A](
    as: Array[A],
    key: A,
    gt: (A, A) => Boolean
): Int = {
  @tailrec
  def go(low: Int, mid: Int, high: Int): Int = {
    if (low > high) -mid - 1
    else {
      val mid2 = (low + high) / 2
      val d = as(mid2)
      val greater = gt(d, key)
      if (!greater && !gt(key, d)) mid2
      else if (greater) go(low, mid2, mid2 - 1)
      else go(mid2 + 1, mid2, high)
    }
  }
  go(0, 0, as.length - 1)
}

val ds = Array(0.0, 1.0, 3.0, 9.0, 4.0, 5.0, 6.0)
binarySearch(ds, 9.0, _ > _)

def isSorted[A](ds: Array[A], gt: (A, A) => Boolean): Boolean = {
  true
}
