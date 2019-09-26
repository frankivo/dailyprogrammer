import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestFit3 {

  @Test
  def test1000(): Unit =
    assertEquals(1000, Boxes.fit3(10, 10, 10, 1, 1, 1))

  @Test
  def test32(): Unit =
    assertEquals(32, Boxes.fit3(12, 34, 56, 7, 8, 9))

  @Test
  def test32604(): Unit =
    assertEquals(32604, Boxes.fit3(123, 456, 789, 10, 11, 12))

  @Test
  def test174648(): Unit =
    assertEquals(174648,
      Boxes.fit3(1234567, 89101112, 13141516, 171819, 202122, 232425))
}
