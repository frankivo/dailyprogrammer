/*
  Call a word perfectly balanced if its code has the same number of dots as dashes.
  counterdemonstrations is one of two 21-letter words that's perfectly balanced. Find the other one.
 */

object bonus3 {
  def main(args: Array[String]): Unit = {
    helper
      .getFile("https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt")
      .getLines
      .filter(x => x.length.equals(21)) // Filter only words of length 21
      .filter(x => !x.equals("counterdemonstrations")) // Filter out "counterdemonstrations"
      .map(w => (w, morse.smorse(w))) // Calculate morse
      .flatMap(x => { // Keep morse words with an equal amount of dots and dashes
        var dots = 0
        var dashes = 0
        x._2.foreach(x => { // Count dots and dashes for morse
          if (x.equals('.')) dots = dots + 1
          else dashes = dashes + 1
        })
        if (dots == dashes) Some(x._1)
        else None
      })
      .foreach(println)
  }
}
