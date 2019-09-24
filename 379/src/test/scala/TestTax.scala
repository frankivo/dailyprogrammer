import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class TestTax {
  @Test
  def amount0(): Unit = assertEquals(0, Tax.tax(0))

  @Test
  def amount10000(): Unit = assertEquals(0, Tax.tax(10_000))

  @Test
  def amount10009(): Unit = assertEquals(1, Tax.tax(10_009))

  @Test
  def amount10010(): Unit = assertEquals(1, Tax.tax(10_010))

  @Test
  def amount12000(): Unit = assertEquals(200, Tax.tax(12_000))

  @Test
  def amount56789(): Unit = assertEquals(8_697, Tax.tax(56_789))

  @Test
  def amount1234567(): Unit = assertEquals(473_326, Tax.tax(1_234_567))
}
