package com.github.frankvio

object SmallestPositiveNumber {
  def find(numbers: Seq[Int]): Int = (1 to numbers.max).filterNot(numbers.filter(_ > 0).sorted.contains(_)).head
}
