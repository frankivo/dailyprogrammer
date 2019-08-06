import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class testSmorse {
  @Test
  def testSos(): Unit = {
    val input = "sos"
    val expected = "...---..."
    assertEquals(expected, morse.smorse(input))
  }

  @Test
  def testDaily(): Unit = {
    val input = "daily"
    val expected = "-...-...-..-.--"
    assertEquals(expected, morse.smorse(input))
  }

  @Test
  def testProgrammer(): Unit = {
    val input = "programmer"
    val expected = ".--..-.-----..-..-----..-."
    assertEquals(expected, morse.smorse(input))
  }

  @Test
  def testBits(): Unit = {
    val input = "bits"
    val expected = "-.....-..."
    assertEquals(expected, morse.smorse(input))
  }

  @Test
  def testThree(): Unit = {
    val input = "three"
    val expected = "-.....-..."
    assertEquals(expected, morse.smorse(input))
  }
}
