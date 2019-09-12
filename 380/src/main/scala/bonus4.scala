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
      .filter(x => x.length.equals(13) )  // filter 13 letter words
      .map(w => (w, morse.smorse(w))) // Calculate morse
      .filter(x => x._2.reverse.equals(x._2)) // Filter palindromes
      .map(x => x._1)  // Return only word
      .foreach(println)
  }
}
