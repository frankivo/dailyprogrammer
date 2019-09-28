import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestWarmup2 {
  @Test
  def testGeneric(): Unit = {
    val input = Array(5, 1, 3, 4, 2)
    val expected = Array(5, 4, 3, 2, 1)

    val result = main.warmup2(input)
    assertArrayEquals(expected, result)
    assertEquals(5, result.length)
  }

  @Test
  def testMultipleZeros(): Unit = {
    val input = Array(0, 0, 0, 4, 0)
    val expected = Array(4, 0, 0, 0, 0)

    val result = main.warmup2(input)
    assertArrayEquals(expected, result)
    assertEquals(5, result.length)
  }

  @Test
  def testSingleElement(): Unit = {
    val input = Array(1)
    val expected = Array(1)

    val result = main.warmup2(input)
    assertArrayEquals(expected, result)
    assertEquals(1, result.length)
  }

  @Test
  def testEmptySet(): Unit = {
    val input = Array[Int]()
    val expected = Array[Int]()

    val result = main.warmup2(input)
    assertArrayEquals(expected, result)
    assertEquals(0, result.length)
  }
}
