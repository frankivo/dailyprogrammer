import junit.framework.TestCase
import org.junit.Assert._

class TestUpc extends TestCase {

  def testChecksum1(): Unit = assertEquals(2, Upc.calcChecksum(3600029145L))

  def testChecksum2(): Unit = assertEquals(4, Upc.calcChecksum(4210000526L))

  def testChecksum3(): Unit = assertEquals(2, Upc.calcChecksum(3_600_029_145L))

  def testChecksum4(): Unit = assertEquals(4, Upc.calcChecksum(12_345_678_910L))

  def testChecksum5(): Unit = assertEquals(0, Upc.calcChecksum(1234567L))

  def testStep1(): Unit = assertEquals(14, Upc.step1(3_600_029_145L))

  def testStep2(): Unit = assertEquals(42, Upc.step2(14))

  def testStep3(): Unit = assertEquals(58, Upc.step3(3_600_029_145L, 42))

  def testStep4(): Unit = assertEquals(8, Upc.step4(58))

  def testStep5Zero(): Unit = assertEquals(0, Upc.step5(0))

  def testStep5NonZero(): Unit = assertEquals(2, Upc.step5(8))

}
