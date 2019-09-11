/*
 The sequence -...-....-.--. is the code for four different words (needing, nervate, niding, tiling).
 Find the only sequence that's the code for 13 different words.
 */

object bonus1 {
  def main(args: Array[String]): Unit = {
    // morse => Array of words
    val map = scala.collection.mutable.Map[String, Array[String]]()

    helper
      .getFile("https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt")
      .getLines
      .map(w => (morse.smorse(w), w)) // Calculate morse
      .foreach(x => map(x._1) = map.getOrElse(x._1, Array[String]()) ++ Array[String](x._2)) // Store morse in map

    map
      .flatMap(x => { // Filter only morse that has 13 source-words.
        if (x._2.length.equals(13)) Some(x)
        else None
      })
      .foreach(x => println(x._1))
  }
}
