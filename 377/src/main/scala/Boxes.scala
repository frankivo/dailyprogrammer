/*
https://www.reddit.com/r/dailyprogrammer/comments/bazy5j/20190408_challenge_377_easy_axisaligned_crate/
 */

case class Point(x: Int, y: Int)

object Boxes {
  /*
  For instance, if the crate is size X = 25 by Y = 18, and the boxes are size x = 6 by y = 5, then the answer is 12.
  You can fit 4 boxes along the x-axis (because 6*4 <= 25), and 3 boxes along the y-axis (because 5*3 <= 18),
  so in total you can fit 4*3 = 12 boxes in a rectangle.
   */
  def fit1(crate: Point, box: Point): Int = (crate.x / box.x) * (crate.y / box.y)

  /*
  You now have the option of rotating all boxes by 90 degrees,
  so that you can treat a set of 6-by-5 boxes as a set of 5-by-6 boxes.
  You do not have the option of rotating some of the boxes but not others.
   */
  def fit2(crate: Point, box: Point): Int = 0
}
