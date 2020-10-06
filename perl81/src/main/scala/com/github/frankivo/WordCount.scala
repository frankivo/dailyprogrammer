package com.github.frankivo

object WordCount {

  def countWords(text: String): Map[Int, Iterable[String]] = {
    val clean = cleanText(text)
    val words = toWords(clean)

    words
      .groupMapReduce(identity)(_ => 1)(_ + _)
      .groupBy(c => c._2)
      .map(x => (x._1, x._2.keys))
  }

  def cleanText(input: String): String = input.replaceAll("(\\.|\"|\\(|\\)|,|'s|--)", "")

  def toWords(input: String): Seq[String] = input.split(" ").filter(_.length > 0)

}
