import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestWarmup3 {
  @Test
  def testSevenElements(): Unit = {
    val count = 7
    val input = Array(6, 5, 5, 3, 2, 2, 2)

    assertFalse(main.warmup3(count, input))
  }

  @Test
  def testFiveFives(): Unit = {
    val count = 5
    val input = Array(5, 5, 5, 5, 5)

    assertFalse(main.warmup3(count, input))
  }

  @Test
  def testFourFives(): Unit = {
    val count = 5
    val input = Array(5, 5, 5, 5)

    assertTrue(main.warmup3(count, input))
  }

  @Test
  def testTwoOnes(): Unit = {
    val count = 3
    val input = Array(1, 1)

    assertTrue(main.warmup3(count, input))
  }

  @Test
  def testOne(): Unit = {
    val count = 1
    val input = Array[Int]()

    assertTrue(main.warmup3(count, input))
  }

  @Test
  def testZero(): Unit = {
    val count = 0
    val input = Array[Int]()

    assertFalse(main.warmup3(count, input))
  }
}
