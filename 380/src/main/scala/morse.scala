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
