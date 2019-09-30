import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestWarmup4 {
  @Test
  def testFourOfFive(): Unit = {
    val input = Array(5, 4, 3, 2, 1)
    val expected = Array(4, 3, 2, 1, 1)

    val result = main.warmup4(4, input)
    assertArrayEquals(expected, result)
    assertEquals(input.length, result.length)
  }

  @Test
  def testElevenElements(): Unit = {
    val input = Array(14, 13, 13, 13, 12, 10, 8, 8, 7, 7, 6, 6, 4, 4, 2)
    val expected = Array(13, 12, 12, 12, 11, 9, 7, 7, 6, 6, 5, 6, 4, 4, 2)

    val result = main.warmup4(11, input)
    assertArrayEquals(expected, result)
    assertEquals(input.length, result.length)
  }

  @Test
  def testFirstElement(): Unit = {
    val input = Array(10, 10, 10)
    val expected = Array(9, 10, 10)

    val result = main.warmup4(1, input)
    assertArrayEquals(expected, result)
    assertEquals(input.length, result.length)
  }

  @Test
  def testAllElement(): Unit = {
    val input = Array(10, 10, 10)
    val expected = Array(9, 9, 9)

    val result = main.warmup4(3, input)
    assertArrayEquals(expected, result)
    assertEquals(input.length, result.length)
  }

  @Test
  def testSingleElement(): Unit = {
    val input = Array(1)
    val expected = Array(0)

    val result = main.warmup4(1, input)
    assertArrayEquals(expected, result)
    assertEquals(input.length, result.length)
  }

  @Test
  def testNothing(): Unit = {
    val input = Array(1, 2, 3)
    val expected = Array(1, 2, 3)

    val result = main.warmup4(0, input)
    assertArrayEquals(expected, result)
    assertEquals(input.length, result.length)
  }
}
