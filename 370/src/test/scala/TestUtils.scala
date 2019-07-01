import junit.framework.TestCase
import org.junit.Assert._

class TestUtils extends TestCase {
  def testFill(): Unit = {
    import Utils.LongUtils

    assertEquals("00000000123", 123L.fill())
  }

  def testLongIntListWithFill(): Unit = {
    import Utils.LongUtils

    val exp = List(1, 2, 3)
    val act = 123L.toIntList

    assertEquals(exp, act)
    assertEquals(3, act.length)
  }

  def testLongIntListWithoutFill(): Unit = {
    import Utils.LongUtils

    val exp = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0)
    val act = 12345678910L.toIntList

    assertEquals(exp, act)
    assertEquals(11, act.length)
  }

  def testStringIntList(): Unit = {
    import Utils.StringUtils

    val exp = List(1, 2, 3)
    val act = "123".toIntList

    assertEquals(exp, act)
  }

}
