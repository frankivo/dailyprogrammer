/*
https://www.reddit.com/r/dailyprogrammer/comments/bazy5j/20190408_challenge_377_easy_axisaligned_crate/
 */

object Boxes {
  /*
  For instance, if the crate is size X = 25 by Y = 18, and the boxes are size x = 6 by y = 5, then the answer is 12.
  You can fit 4 boxes along the x-axis (because 6*4 <= 25), and 3 boxes along the y-axis (because 5*3 <= 18),
  so in total you can fit 4*3 = 12 boxes in a rectangle.
   */
  def fit1(crateX: Int, crateY: Int, boxX: Int, boxY: Int): Int = (crateX / boxX) * (crateY / boxY)

  /*
  You now have the option of rotating all boxes by 90 degrees,
  so that you can treat a set of 6-by-5 boxes as a set of 5-by-6 boxes.
  You do not have the option of rotating some of the boxes but not others.
   */
  def fit2(crateX: Int, crateY: Int, boxX: Int, boxY: Int): Int = {
    val a = fit1(crateX, crateY, boxX, boxY)
    val b = fit1(crateX, crateY, boxY, boxX)
    if (a > b) a else b
  }

  /*
  You're now given six parameters, X, Y, Z, x, y, and z.
  That is, you're given the X, Y, and Z dimensions of the crate, and the x, y, and z dimensions of the boxes.
  There are now six different possible orientations of the boxes.
  Again, boxes cannot be rotated independently: they all have to have the same orientation.
   */
  def fit3(crateX: Int, crateY: Int, createZ: Int, boxX: Int, boxY: Int, boxZ: Int): Int = {
    List(
      (crateX / boxX) * (crateY / boxY) * (createZ / boxZ),
      (crateX / boxX) * (crateY / boxZ) * (createZ / boxY),
      (crateX / boxY) * (crateY / boxX) * (createZ / boxZ),
      (crateX / boxY) * (crateY / boxZ) * (createZ / boxX),
      (crateX / boxZ) * (crateY / boxX) * (createZ / boxY),
      (crateX / boxZ) * (crateY / boxY) * (createZ / boxX),
    ).max
  }

  /*
  Now you take a list of N crate dimensions, and N box dimensions.
  Assume that the boxes may be rotated in any of N! orientations so that each axis of the crate aligns with a different axis of the boxes.
  Again, boxes cannot be rotated independently.
   */
  def fitN(crates: List[Int], boxes: List[Int]): Int = {
    0
  }
}
