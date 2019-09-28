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
  def warmup3(count: Int, numbers: Array[Int]): Boolean = count > numbers.length
}
