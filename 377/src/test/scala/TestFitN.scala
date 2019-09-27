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

  @Test
  def test20(): Unit = // This is really slow
    assertEquals(BigInt("4281855455197643306306491981973422080000"),
      Boxes.fitN(
        List(180598, 125683, 146932, 158296, 171997, 204683, 193694, 216231, 177673, 169317, 216456, 220003,
          165939, 205613, 152779, 177216, 128838, 126894, 210076, 148407),
        List(1984, 2122, 1760, 2059, 1278, 2017, 1443, 2223, 2169, 1502, 1274, 1740, 1740, 1768, 1295, 1916, 2249,
          2036, 1886, 2010)
      ))
}
