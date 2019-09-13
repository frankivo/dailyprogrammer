/*
https://www.reddit.com/r/dailyprogrammer/comments/cdieag/20190715_challenge_379_easy_progressive_taxation/
 */

case class Bracket(incomeCap: Option[Long], taxRate: Double)

case class LimitedBracket(min: Long, max: Long, rate: Double)

object Tax {
  private val Taxes = List[Bracket](
    Bracket(Some(10000L), 0.0),
    Bracket(Some(30000L), 0.1),
    Bracket(Some(100000L), 0.25),
    Bracket(None, 0.4),
  )

  def tax(amount: Long): Long = {
    Taxes.reverse.foreach(println)

    1337L
  }

  def calcLimits: List[LimitedBracket] = {
    List()
  }

  def main(args: Array[String]): Unit = {
    tax(10010)
  }
}
