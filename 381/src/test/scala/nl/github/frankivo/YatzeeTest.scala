package nl.github.frankivo

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class YatzeeTest {
  @Test
  def test10(): Unit = assertEquals(10, Yatzee.yahtzee_upper(Array(2, 3, 5, 5, 6)))

  @Test
  def test4(): Unit = assertEquals(4, Yatzee.yahtzee_upper(Array(1, 1, 1, 1, 3)))

  @Test
  def test6(): Unit = assertEquals(6, Yatzee.yahtzee_upper(Array(1, 1, 1, 3, 3)))

  @Test
  def test5(): Unit = assertEquals(5, Yatzee.yahtzee_upper(Array(1, 2, 3, 4, 5)))

  @Test
  def test30(): Unit = assertEquals(30, Yatzee.yahtzee_upper(Array(6, 6, 6, 6, 6)))
}
