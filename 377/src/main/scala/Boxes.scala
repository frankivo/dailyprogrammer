/*
https://www.reddit.com/r/dailyprogrammer/comments/bazy5j/20190408_challenge_377_easy_axisaligned_crate/

For instance, if the crate is size X = 25 by Y = 18, and the boxes are size x = 6 by y = 5, then the answer is 12.
You can fit 4 boxes along the x-axis (because 6*4 <= 25), and 3 boxes along the y-axis (because 5*3 <= 18),
  so in total you can fit 4*3 = 12 boxes in a rectangle.
 */

case class Point(x: Int, y: Int)

object Boxes {
  def fit1(crate: Point, box: Point): Int = {
    0
  }

  def main(args: Array[String]): Unit = {
    List(
      (Point(25, 18), Point(6, 5)),
      (Point(10, 10), Point(1, 1)),
      (Point(12, 34), Point(5, 6)),
      (Point(12345, 678910), Point(1112, 1314)),
      (Point(5, 100), Point(6, 1))
    ).foreach(x => {
      println(x)
      println(fit1(x._1, x._2))
    })
  }
}
