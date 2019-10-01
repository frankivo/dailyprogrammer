import scala.util.Random

// https://www.reddit.com/r/dailyprogrammer/comments/2s7ezp/20150112_challenge_197_easy_isbn_validator/

object ISBN10 {
  /*
  Obtain the sum of 10 times the first digit, 9 times the second digit, 8 times the third digit...
   all the way till you add 1 times the last digit.
   If the sum leaves no remainder when divided by 11 the code is a valid ISBN.
   */
  def validate(isbn: String): Boolean = {
    isbn
      .toUpperCase // Convert: x -> X
      .filter(x => x.isDigit || x.equals('X')) // Strip: anything that isn't a digit or an X
      .map(c => if (c.equals('X')) 10 else c.asDigit) // Convert: X -> 10
      .reverse // Reverse: to make the next step easier
      .zipWithIndex // Give every number an index
      .map(n => (n._1, n._2 + 1)) // Index + 1 for multiplier
      .map(n => n._1 * n._2) // Sum per digit
      .sum % 11 == 0 // Divide by 11 should result in 0
  }

  def generate: String = {
    val code = (1 to 9).map(_ => Random.nextInt(9))
    val sum = code
      .reverse
      .zipWithIndex
      .map(x => (x._1, x._2 + 2))
      .map(z => z._1 * z._2)
      .sum
    val rest = (0 to 10)
      .filter(i => (sum + i) % 11 == 0)
      .map(x => if (x == 10) 'X' else x)
      .head
    code.mkString + rest
  }
}
