import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestWarmup1 {
  @Test
  def testMultipleRemovals(): Unit = {
    val input = Array(5, 3, 0, 2, 6, 2, 0, 7, 2, 5)
    val expected = Array(5, 3, 2, 6, 2, 7, 2, 5)
    assertArrayEquals(expected, main.warmup1(input))
  }

  @Test
  def testTwoConsecutive(): Unit = {
    val input = Array(4, 0, 0, 1, 3)
    val expected = Array(4, 1, 3)
    assertArrayEquals(expected, main.warmup1(input))
  }

  @Test
  def testNoRemovals(): Unit = {
    val input = Array(1, 2, 3)
    val expected = Array(1, 2, 3)
    assertArrayEquals(expected, main.warmup1(input))
  }

  @Test
  def testEmptyOutput(): Unit = {
    val input = Array(0, 0, 0)
    val expected = Array[Int]()
    assertArrayEquals(expected, main.warmup1(input))
  }

  @Test
  def testEmptyInput(): Unit = {
    val input = Array[Int]()
    val expected = Array[Int]()
    assertArrayEquals(expected, main.warmup1(input))
  }
}
