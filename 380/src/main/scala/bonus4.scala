/*
  protectorate is 12 letters long and encodes to .--..-.----.-.-.----.-..--.,
  which is a palindrome (i.e. the string is the same when reversed).
  Find the only 13-letter word that encodes to a palindrome.
 */

object bonus4 {
  def main(args: Array[String]): Unit = {
    helper
      .getFile("https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt")
      .getLines
      .flatMap(x => { // filter 13 letter words
        x.length match {
          case 13 => Some(x)
          case _ => None
        }
      })
      .map(w => (w, morse.smorse(w))) // Calculate morse
      .flatMap(x => { // filter palindromes
        if (x._2.reverse.equals(x._2)) Some(x._1)
        else None
      })
      .foreach(println)
  }
}
