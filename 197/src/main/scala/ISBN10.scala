import scala.util.Random

object ISBN10 {
  def validate(isbn: String): Boolean = {
    isbn
      .toUpperCase
      .filter(x => x.isDigit || x.equals('X'))
      .map(c => if (c.equals('X')) 10 else c.asDigit)
      .reverse
      .zipWithIndex
      .map(n => (n._1, n._2 + 1))
      .map(n => n._1 * n._2)
      .sum % 11 == 0
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
