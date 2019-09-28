/*
  https://www.reddit.com/r/dailyprogrammer/comments/bqy1cf/20190520_challenge_378_easy_the_havelhakimi/
 */

object main {
  // Given a sequence of answers, return the same set of answers with all the 0's removed.
  def warmup1(numbers: Array[Int]): Array[Int] = numbers.filter(_ != 0)

  // Given a sequence of answers, return the sequence sorted in descending order,
  // so that the first number is the largest and the last number is the smallest.
  def warmup2(numbers: Array[Int]): Array[Int] = numbers.sorted.reverse

  // Given a number N and a sequence of answers,
  // return true if N is greater than the number of answers (i.e. the length of the sequence),
  // and false if N is less than or equal to the number of answers.
  // For instance, given 7 and [6, 5, 5, 3, 2, 2, 2], you would return false, because 7 is less than or equal to 7.
  def warmup3(count: Int, numbers: Array[Int]): Boolean = false
}
