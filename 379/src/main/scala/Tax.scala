/*
https://www.reddit.com/r/dailyprogrammer/comments/cdieag/20190715_challenge_379_easy_progressive_taxation/
 */

case class Bracket(max: Option[Int], rate: Double)

case class LimitedBracket(min: Int, max: Int, rate: Double)

object Tax {
  val Taxes: List[Bracket] = List[Bracket](
    Bracket(Some(10_000), 0.0),
    Bracket(Some(30_000), 0.10),
    Bracket(Some(100_000), 0.25),
    Bracket(None, 0.40)
  )

  def calcTaxes: List[LimitedBracket] = {
    var min = 0

    Taxes.map(t => {
      val max = t.max.getOrElse(Int.MaxValue)
      val bracket = LimitedBracket(min, max, t.rate)
      min = max
      bracket
    })
  }

  def tax(amount: Int): Int = {
    var tax = 0

    calcTaxes.foreach(bracket => {
      var toTax = 0

      if (amount > bracket.max)
        toTax = bracket.max - bracket.min
      else if (amount > bracket.min)
        toTax = amount - bracket.min

      tax = tax + (toTax * bracket.rate).round.toInt
    })

    tax
  }

  def main(args: Array[String]): Unit = {
    List(0, 10_000, 10_009, 10_010, 12_000, 56_789, 1_234_567)
      .foreach(a => println("%s: %s".format(a, tax(a))))
  }
}
