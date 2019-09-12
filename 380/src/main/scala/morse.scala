/*
  https://www.reddit.com/r/dailyprogrammer/comments/cmd1hb/20190805_challenge_380_easy_smooshed_morse_code_1/
 */

object morse {
  val charsRaw = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.."

  def main(args: Array[String]): Unit = {
    smorse("sos")
    smorse("daily")
    smorse("programmer")
    smorse("bits")
    smorse("three")
  }

  def getChars: Seq[String] = charsRaw.split(" ").toSeq

  def getMorse(c: Char): String = getChars(c.toInt - 97)

  def smorse(msg: String): String = msg.map(c => getMorse(c)).mkString

}
