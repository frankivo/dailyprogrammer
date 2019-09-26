import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestFit1 {

  @Test
  def test12(): Unit = assertEquals(12, Boxes.fit1(25, 18, 6, 5))

  @Test
  def test100(): Unit = assertEquals(100, Boxes.fit1(10, 10, 1, 1))

  @Test
  def test10(): Unit = assertEquals(10, Boxes.fit1(12, 34, 5, 6))

  @Test
  def test5676(): Unit = assertEquals(5676, Boxes.fit1(12345, 678910, 1112, 1314))

  @Test
  def test0(): Unit = assertEquals(0, Boxes.fit1(5, 6, 6, 1))
}
