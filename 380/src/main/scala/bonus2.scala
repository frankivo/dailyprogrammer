object bonus2 {
  def main(args: Array[String]): Unit = {
    helper
      .getFile("https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt")
      .getLines
      .map(w => (w, morse.smorse(w)))
      .flatMap(m => {
        if (m._2.contains("---------------")) Some(m._1)
        else None
      })
      .foreach(println)
  }

}
