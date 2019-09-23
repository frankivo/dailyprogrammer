/*
https://www.reddit.com/r/dailyprogrammer/comments/cdieag/20190715_challenge_379_easy_progressive_taxation/
 */

case class Bracket(incomeCap: Option[Int], taxRate: Double)

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
      val t = Taxes(i)
      val max = t.max.getOrElse(Int.MaxValue)

      //      println(amount + " : " + max)
      if (amount > max) {
        tax = tax + (t.rate * max).toInt
      }
      else {
        val maxSum = Taxes.take(i - 1).map(x => x.max.getOrElse(Int.MaxValue)).sum
        val toTax = amount - maxSum
        val newTax = (t.rate * toTax).toInt
        tax = tax + newTax
      }
    }

    tax
  }

  def main(args: Array[String]): Unit = {
    println(tax(40000))
    //    tax(40000)
  }
}
