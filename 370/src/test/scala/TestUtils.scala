import junit.framework.TestCase
import org.junit.Assert._

class TestUtils extends TestCase {
  def testFill(): Unit = {
    import Utils.LongUtils

    assertEquals("00000000123", 123L.fill())
  }

  def testLongIntList(): Unit = {
    import Utils.LongUtils

    val exp = List(1, 2, 3)
    val act = 123L.toIntList

    assertEquals(exp, act)
  }

  def testStringIntList(): Unit = {
    import Utils.StringUtils

    val exp = List(1, 2, 3)
    val act = "123".toIntList

    assertEquals(exp, act)
  }

}
