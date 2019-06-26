import junit.framework.TestCase
import org.junit.Assert._

class TestUpc extends TestCase {

  def testMe(): Unit = {
    val expected = 4
    val actual = Upc.calcChecksum(4210000526L)
    assertEquals(expected, actual)
  }

  def testStep1(): Unit = {
    val code = 3_600_029_145L
    val sum = 14

    assertEquals(sum, Upc.step1(code))
  }

  def testStep2() : Unit = {
    assertEquals(42, Upc.step2(14))
  }

}
