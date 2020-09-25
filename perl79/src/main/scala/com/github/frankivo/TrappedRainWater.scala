// https://perlweeklychallenge.org/blog/perl-weekly-challenge-079/#TASK2

package com.github.frankivo

object TrappedRainWater {
  def getAmount(water: Array[Int]): Int = {
    printHistogram(water)
    0
  }

  def printHistogram(water: Array[Int]): Unit = {
    val height = water.max
    val indices = (1 to height).reverse

    (1 to height).foreach(i => {
      val curHeight = indices(i - 1)

      print(indices(i - 1))
      water.foreach(w => print(" %s".format(if (curHeight <= w) "#" else " ")))

      println
    })

    println("- " * (water.length + 1))
    println(" " * 2 + water.mkString(" "))
  }
}
