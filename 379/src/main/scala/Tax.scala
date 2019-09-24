/*
https://www.reddit.com/r/dailyprogrammer/comments/cdieag/20190715_challenge_379_easy_progressive_taxation/
 */

case class LimitedBracket(min: Int, max: Int, rate: Double)

object Tax {
  private val Taxes = List[LimitedBracket](
    LimitedBracket(0, 10000, 0.00),
    LimitedBracket(10_000, 30_000, 0.10),
    LimitedBracket(30_000, 100_000, 0.25),
    LimitedBracket(100_000, Int.MaxValue, 0.40)
  )

  def tax(amount: Int): Int = {
    var tax = 0

    for (i <- Taxes.indices) {
      val bracket = Taxes(i)
      var toTax = 0

      if (amount > bracket.max)
        toTax = bracket.max - bracket.min
      else if (amount > bracket.min)
        toTax = amount - Taxes.take(i).map(t => t.max - t.min).sum

      tax = tax + (toTax * bracket.rate).round.toInt
    }

    tax
  }

  def main(args: Array[String]): Unit = {
    List(0, 10_000, 10_009, 10_010, 12_000, 56_789, 1_234_567)
      .foreach(a => println("%s: %s".format(a, tax(a))))
  }
}
