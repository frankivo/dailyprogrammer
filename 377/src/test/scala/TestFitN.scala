import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestFitN {

  @Test
  def test6(): Unit = assertEquals(6, Boxes.fitN(
    List(3, 4),
    List(1, 2))
  )

  @Test
  def test32604(): Unit = assertEquals(32604, Boxes.fitN(
    List(123, 456, 789),
    List(10, 11, 12))
  )

  @Test
  def test1883443968(): Unit = assertEquals(1883443968, Boxes.fitN(
    List(123, 456, 789, 1011, 1213, 1415),
    List(16, 17, 18, 19, 20, 21))
  )
}
