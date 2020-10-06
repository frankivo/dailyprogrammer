// https://perlweeklychallenge.org/blog/perl-weekly-challenge-079/#TASK1

package com.github.frankivo

object CountSetBits {
  def getBits(n: Int): Int = (1 to n).map(_.toBinaryString.count(_ == '1')).sum
}