import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestHavelHakimi {
  @Test
  def test1(): Unit = assertFalse(main.hh(Array(5, 3, 0, 2, 6, 2, 0, 7, 2, 5)))

  @Test
  def test2(): Unit = assertFalse(main.hh(Array(4, 2, 0, 1, 5, 0)))

  @Test
  def test3(): Unit = assertTrue(main.hh(Array(3, 1, 2, 3, 1, 0)))

  @Test
  def test4(): Unit =
    assertTrue(main.hh(Array(16, 9, 9, 15, 9, 7, 9, 11, 17, 11, 4, 9, 12, 14, 14, 12, 17, 0, 3, 16)))

  @Test
  def test5(): Unit =
    assertTrue(main.hh(Array(14, 10, 17, 13, 4, 8, 6, 7, 13, 13, 17, 18, 8, 17, 2, 14, 6, 4, 7, 12)))

  @Test
  def test6(): Unit =
    assertFalse(main.hh(Array(15, 18, 6, 13, 12, 4, 4, 14, 1, 6, 18, 2, 6, 16, 0, 9, 10, 7, 12, 3)))

  @Test
  def test7(): Unit =
    assertFalse(main.hh(Array(6, 0, 10, 10, 10, 5, 8, 3, 0, 14, 16, 2, 13, 1, 2, 13, 6, 15, 5, 1)))

  @Test
  def test8(): Unit = assertFalse(main.hh(Array(2, 2, 0)))

  @Test
  def test9(): Unit = assertFalse(main.hh(Array(3, 2, 1)))

  @Test
  def test10(): Unit = assertTrue(main.hh(Array(1, 1)))

  @Test
  def test11(): Unit = assertFalse(main.hh(Array(1)))

  @Test
  def test12(): Unit = assertTrue(main.hh(Array()))
}
