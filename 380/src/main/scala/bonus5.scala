import scala.collection.mutable

/*
  --.---.---.-- is one of five 13-character sequences that does not appear in the encoding of any word. Find the other four.
 */

object bonus5 {
  def main(args: Array[String]): Unit = {
    val allMorse = helper
      .getFile("https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt")
      .getLines()
      .map(l => morse.smorse(l))
      .toSet

    generateSequences
      .filter(x => !allMorse.exists(k => k.contains(x)))
      .filter(x => !x.equals("--.---.---.--"))
      .foreach(println)
  }

  def generateSequences: Array[String] = {
    val list = mutable.MutableList[String]()
    generateWords(list)
    list.toArray
  }

  def generateWords(list: mutable.MutableList[String], word: String = ""): Unit = {
    if (word.length == 13)
      list += word
    else {
      generateWords(list, word + '.')
      generateWords(list, word + '-')
    }
  }
}
