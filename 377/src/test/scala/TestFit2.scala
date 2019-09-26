import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestFit2 {

  @Test
  def test15(): Unit = {
    val crate = Point(25, 18)
    val box = Point(6, 5)
    assertEquals(15, Boxes.fit2(crate, box))
  }

  @Test
  def test12(): Unit = {
    val crate = Point(12, 34)
    val box = Point(5, 6)
    assertEquals(12, Boxes.fit2(crate, box))
  }

  @Test
  def test5676(): Unit = {
    val crate = Point(12345, 678910)
    val box = Point(1112, 1314)
    assertEquals(5676, Boxes.fit2(crate, box))
  }

  @Test
  def test2(): Unit = {
    val crate = Point(5, 5)
    val box = Point(3, 2)
    assertEquals(2, Boxes.fit2(crate, box))
  }

  @Test
  def test80(): Unit = {
    val crate = Point(5, 100)
    val box = Point(6, 1)
    assertEquals(80, Boxes.fit2(crate, box))
  }

  @Test
  def test0(): Unit = {
    val crate = Point(5, 5)
    val box = Point(6, 1)
    assertEquals(0, Boxes.fit2(crate, box))
  }

}
