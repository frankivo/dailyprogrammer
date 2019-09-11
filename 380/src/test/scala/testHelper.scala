import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class testHelper {

  @Test
  def testFilename(): Unit = {
    val url = "https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt"
    val expected = "enable1.txt"

    val filename = helper.getFilename(url)

    assertEquals(expected, filename)
  }
}
