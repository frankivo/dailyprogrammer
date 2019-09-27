import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestFit2 {

  @Test
  def test15(): Unit = assertEquals(15, Boxes.fit2(25, 18, 6, 5))

  @Test
  def test12(): Unit = assertEquals(12, Boxes.fit2(12, 34, 5, 6))

  @Test
  def test5676(): Unit = assertEquals(5676, Boxes.fit2(12345, 678910, 1112, 1314))

  @Test
  def test2(): Unit = assertEquals(2, Boxes.fit2(5, 5, 3, 2))

  @Test
  def test80(): Unit = assertEquals(80, Boxes.fit2(5, 100, 6, 1))

  @Test
  def test0(): Unit = assertEquals(0, Boxes.fit2(5, 5, 6, 1))

}
