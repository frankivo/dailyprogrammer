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

  /*
    Remove all 0's from the sequence (i.e. warmup1). If the sequence is now empty (no elements left), stop and return true.
    Sort the sequence in descending order (i.e. warmup2).
    Remove the first answer (which is also the largest answer, or tied for the largest) from the sequence and call it N.
      The sequence is now 1 shorter than it was after the previous step.
    If N is greater than the length of this new sequence (i.e. warmup3), stop and return false.
    Subtract 1 from each of the first N elements of the new sequence (i.e. warmup4).
    Continue from step 1 using the sequence from the previous step.
   */
  @scala.annotation.tailrec
  def hh(answers: Array[Int]): Boolean =
    answers.filter(_ != 0).sorted.reverse match {
      case noZeroes if noZeroes.length.equals(0) => true
      case noZeroes => noZeroes match {
        case sorted if sorted.head > sorted.slice(1, sorted.length).length => false
        case sorted => hh(
          sorted.slice(1, sorted.length).take(sorted.head).map(_ - 1)
            ++ sorted.slice(1, sorted.length).slice(sorted.head, sorted.length - 1)
        )
      }
    }
}
