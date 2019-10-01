object ISBN10 {
  def isISBN(isbn: String): Boolean = {
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
}
