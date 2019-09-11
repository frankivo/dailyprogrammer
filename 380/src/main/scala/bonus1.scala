object bonus1 {
  def main(args: Array[String]): Unit = {
    val map = scala.collection.mutable.Map[String, Array[String]]()

    helper
      .getFile("https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt")
      .getLines
      .map(w => (morse.smorse(w), w))
      .foreach(x => map(x._1) = map.getOrElse(x._1, Array[String]()) ++ Array[String](x._2))

    map
      .flatMap(x => {
        if (x._2.length.equals(13)) Some(x)
        else None
      })
      .foreach(x => println(x._1))
  }
}
