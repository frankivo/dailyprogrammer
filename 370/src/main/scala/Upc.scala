/* https://www.reddit.com/r/dailyprogrammer/comments/a72sdj/20181217_challenge_370_easy_upc_check_digits/


    1. Sum the digits at odd-numbered positions (1st, 3rd, 5th, ..., 11th). If you use 0-based indexing, this is the even-numbered positions (0th, 2nd, 4th, ... 10th).
    2. Multiply the result from step 1 by 3.
    3. Take the sum of digits at even-numbered positions (2nd, 4th, 6th, ..., 10th) in the original number, and add this sum to the result from step 2.
    4. Find the result from step 3 modulo 10 (i.e. the remainder, when divided by 10) and call it M.
    5. If M is 0, then the check digit is 0; otherwise the check digit is 10 - M.

    For example, given the first 11 digits of a UPC 03600029145, you can compute the check digit like this:
    1. Sum the odd-numbered digits (0 + 6 + 0 + 2 + 1 + 5 = 14).
    2. Multiply the result by 3 (14 × 3 = 42).
    3. Add the even-numbered digits (42 + (3 + 0 + 0 + 9 + 4) = 58).
    4. Find the result modulo 10 (58 divided by 10 is 5 remainder 8, so M = 8).
    5. If M is not 0, subtract M from 10 to get the check digit (10 - M = 10 - 8 = 2).
 */

import Utils._

object Upc {
  def calcChecksum(code: Long): Int = {
    val s1 = step1(code)
    val s2 = step2(s1)
    val s3 = step3(code, s2)

    123
  }

  def step1(code: Long): Int = code.toIntList.indices.collect { case i if i % 2 == 1 => code.toIntList(i) }.sum

  def step2(step1: Int): Int = step1 * 3

  def step3(code: Long, step2: Int): Int = {
    val evens = code.toIntList.indices.collect { case i if i % 2 == 0 => code.toIntList(i) }.sum
    evens + step2
  }

  def step4(step3: Int) : Int = step3 % 10

}
