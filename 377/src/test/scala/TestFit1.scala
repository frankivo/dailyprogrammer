import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestFit1 {

  @Test
  def test12(): Unit = {
    val crate = Point(25, 18)
    val box = Point(6, 5)
    assertEquals(12, Boxes.fit1(crate, box))
  }

  @Test
  def test100(): Unit = {
    val crate = Point(10, 10)
    val box = Point(1, 1)
    assertEquals(100, Boxes.fit1(crate, box))
  }

  @Test
  def test10(): Unit = {
    val crate = Point(12, 34)
    val box = Point(5, 6)
    assertEquals(10, Boxes.fit1(crate, box))
  }

  @Test
  def test5676(): Unit = {
    val crate = Point(12345, 678910)
    val box = Point(1112, 1314)
    assertEquals(5676, Boxes.fit1(crate, box))
  }

  @Test
  def test0(): Unit = {
    val crate = Point(5, 100)
    val box = Point(6, 1)
    assertEquals(0, Boxes.fit1(crate, box))
  }
}
