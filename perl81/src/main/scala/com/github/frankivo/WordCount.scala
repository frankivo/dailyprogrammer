package com.github.frankivo

object WordCount {

  def countWords(text: String): List[(Int, Seq[String])] = {
    val clean = cleanText(text)
    val words = toWords(clean)

    val counts = words.groupMapReduce(identity)(_ => 1)(_ + _)
    println(counts)

    List()
  }

  def cleanText(input: String): String = input.replaceAll("(\\.|\"|\\(|\\)|,|'s|--)", "")

  def toWords(input: String): Seq[String] = input.split(" ").filter(_.length > 0)

}
