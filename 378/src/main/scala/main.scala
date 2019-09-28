/*
  https://www.reddit.com/r/dailyprogrammer/comments/bqy1cf/20190520_challenge_378_easy_the_havelhakimi/
 */

object main {
  // Given a sequence of answers, return the same set of answers with all the 0's removed.
  def warmup1(answers: Array[Int]): Array[Int] = answers.filter(_ != 0)

  // Given a sequence of answers, return the sequence sorted in descending order,
  // so that the first number is the largest and the last number is the smallest.
  def warmup2(answers: Array[Int]): Array[Int] = answers.sorted.reverse

  // Given a number N and a sequence of answers,
  // return true if N is greater than the number of answers (i.e. the length of the sequence),
  // and false if N is less than or equal to the number of answers.
  def warmup3(N: Int, answers: Array[Int]): Boolean = N > answers.length

  // Given a number N and a sequence in descending order,
  // subtract 1 from each of the first N answers in the sequence, and return the result.
  def warmup4(N: Int, answers: Array[Int]): Array[Int] =
    answers.take(N).map(_ - 1) ++ answers.slice(N, answers.length)

  def hh(answers: Array[Int]) : Boolean = false
}
