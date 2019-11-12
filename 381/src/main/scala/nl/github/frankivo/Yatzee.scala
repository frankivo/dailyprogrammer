package nl.github.frankivo

/*
  https://www.reddit.com/r/dailyprogrammer/comments/dv0231/20191111_challenge_381_easy_yahtzee_upper_section/
 */

object Yatzee {
  def yahtzee_upper(dice: Array[Int]): Int = {
    dice
      .groupBy(a => a)
      .view
      .mapValues(_.length)
      .map(x => x._1 * x._2)
      .max
  }
}
