package nl.github.frankivo

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.{Arguments, MethodSource}

@TestInstance(PER_CLASS)
class YatzeeTest {

  @ParameterizedTest
  @MethodSource(Array("getDice"))
  def YatzeeTest(expected: Int, dice: Array[Int]): Unit =
    assertEquals(expected, Yatzee.yahtzee_upper(dice.map(_.toLong)))

  private def getDice: Array[Arguments] = Array(
    Arguments.of(10, Array(2, 3, 5, 5, 6)),
    Arguments.of(4, Array(1, 1, 1, 1, 3)),
    Arguments.of(6, Array(1, 1, 1, 3, 3)),
    Arguments.of(5, Array(1, 2, 3, 4, 5)),
    Arguments.of(30, Array(6, 6, 6, 6, 6)),
    Arguments.of(123456, Array(
      1654, 1654, 50995, 30864, 1654, 50995, 22747, 1654, 1654, 1654,
      1654, 1654, 30864, 4868, 1654, 4868, 1654, 30864, 4868, 30864
    ))
  )
}
