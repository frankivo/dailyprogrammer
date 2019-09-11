import scala.collection.mutable

/*
  --.---.---.-- is one of five 13-character sequences that does not appear in the encoding of any word. Find the other four.
 */

object bonus5 {
  def main(args: Array[String]): Unit = {
    generateSequences
  }

  def generateSequences: List[String] = {
    val list = mutable.MutableList[String]()
    generateWords(list)
    list.toList
  }

  def generateWords(list : mutable.MutableList[String], word: String = ""): Unit = {
    word.length match {
      case 13 => list += word
      case _ =>
        generateWords(list, word + "-")
        generateWords(list, word + ".")
    }
  }

}
