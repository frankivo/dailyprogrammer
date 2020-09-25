// https://perlweeklychallenge.org/blog/perl-weekly-challenge-079/

package com.github.frankivo

object Perl79 {
  def getBits(n: Int): Int = (1 to n).map(_.toBinaryString.count(_ == '1')).sum
}