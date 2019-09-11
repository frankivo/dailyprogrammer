/*
  autotomous encodes to .-..--------------..-..., which has 14 dashes in a row. Find the only word that has 15 dashes in a row.
 */

object bonus2 {
  def main(args: Array[String]): Unit = {
    val dash15 = "-" * 15

    helper
      .getFile("https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt")
      .getLines
      .map(w => (w, morse.smorse(w))) // Calculate morse
      .flatMap(m => { // Filter morse with 15 dashes in a row
        if (m._2.contains(dash15)) Some(m._1)
        else None
      })
      .foreach(println)
  }

}
