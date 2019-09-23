/*
https://www.reddit.com/r/dailyprogrammer/comments/cdieag/20190715_challenge_379_easy_progressive_taxation/
 */

case class LimitedBracket(min: Int, max: Option[Int], rate: Double)

object Tax {
  private val Taxes = List[LimitedBracket](
    LimitedBracket(0, Some(10000), 0.0),
    LimitedBracket(10001, Some(30000), 0.1),
    LimitedBracket(30001, Some(100000), 0.25),
    LimitedBracket(1000001, None, 0.4)
  )

  def tax(amount: Int): Int = {
    var tax = 0

    for (i <- Taxes.indices) {
      if (amount > Taxes(i).min) {
        val maxSum = Taxes.take(i).map(x => x.max.getOrElse(Int.MaxValue)).sum
        val toTax = amount - maxSum
        val newTax = (Taxes(i).rate * toTax).round.toInt
        tax = tax + newTax
      }
    }

    tax
  }

  def main(args: Array[String]): Unit = {
    List(0, 10_000, 10_009, 10_010, 12_000, 56_789, 1_234_567)
      .foreach(a => {
        println("%s: %s".format(a, tax(a)))
      })
  }
}
