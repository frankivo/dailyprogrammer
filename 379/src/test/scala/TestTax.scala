import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class TestTax {
  @Test
  def amount0(): Unit = assertEquals(0L, Tax.tax(0))

  @Test
  def amount10000(): Unit = assertEquals(0L, Tax.tax(10000))

  @Test
  def amount10009(): Unit = assertEquals(0L, Tax.tax(10009))

  @Test
  def amount10010(): Unit = assertEquals(1L, Tax.tax(10010))

  @Test
  def amount12000(): Unit = assertEquals(200L, Tax.tax(12000))

  @Test
  def amount56789(): Unit = assertEquals(8697L, Tax.tax(56789))

  @Test
  def amount1234567(): Unit = assertEquals(473326L, Tax.tax(1234567))
}
