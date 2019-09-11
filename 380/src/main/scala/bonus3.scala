object bonus3 {
  def main(args: Array[String]): Unit = {
    helper
      .getFile("https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt")
      .getLines
      .flatMap(x => x.length match { // Filter only words of length 21
        case 21 => Some(x)
        case _ => None
      })
      .map(w => (w, morse.smorse(w))) // Calculate morse
      .flatMap(x => { // Keep morse words with an equal amount of dots and dashes
        var dots = 0
        var dashes = 0
        x._2.foreach(x => { // Count dots and dashes for morse
          if (x.equals('.')) dots = dots + 1
          else dashes = dashes + 1
        })
        if (dots == dashes) Some(x._1)
        else None
      })
      .foreach(println)
  }
}
