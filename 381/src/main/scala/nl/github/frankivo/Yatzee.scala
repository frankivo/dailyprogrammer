package nl.github.frankivo

/*
  https://www.reddit.com/r/dailyprogrammer/comments/dv0231/20191111_challenge_381_easy_yahtzee_upper_section/
 */

object Yatzee {
  def yahtzee_upper(dice: Array[Long]): Long = {
    dice
      .groupBy(a => a)
      .view.mapValues(_.length)
      .map(x => x._1 * x._2)
      .max
  }

  def main(args: Array[String]): Unit = {
    val url = "https://gist.githubusercontent.com/cosmologicon/beadf49c9fe50a5c2a07ab8d68093bd0/raw/" +
      "fb5af1a744faf79d64e2a3bb10973e642dc6f7b0/yahtzee-upper-1.txt"
    val file = Helper.getFile(url)
    val ints = file.getLines.map(_.toLong).toArray

    println(yahtzee_upper(ints))
  }
}
