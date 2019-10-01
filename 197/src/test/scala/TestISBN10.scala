import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestISBN10 {
  @Test
  def testValidISBNs(): Unit = {
    val failed = List("0-7475-3269-9",
      "156881111X",
      "0-471-19047-0",
      "87-11-07559-7",
      "156881111X")
      .flatMap(i => if (ISBN10.validate(i)) None else Some(i))
    assertEquals(0, failed.length)
  }

  @Test
  def testInvalidISBNs(): Unit = {
    val failed = List("0-7475-3269-X",
      "1568811115",
      "0-471-19047-3",
      "87-11-07559-8",
      "1568811113")
      .flatMap(i => if (ISBN10.validate(i)) None else Some(i))
    assertEquals(5, failed.length)
  }

  @Test
  def testGenerate(): Unit = {
    val invalids = (0 to 10_000)
      .map(_ => ISBN10.generate)
      .flatMap(i => if (ISBN10.validate(i)) None else Some(i))
    assertEquals(0, invalids.length)
  }
}
