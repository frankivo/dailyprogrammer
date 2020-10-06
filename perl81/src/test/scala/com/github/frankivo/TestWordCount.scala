package com.github.frankivo

import utest.{ArrowAssert, TestSuite, Tests, test}

object TestWordCount extends TestSuite {
  def getText: String = {
    val s = scala.io.Source.fromFile("src/test/resources/WestSideStory.txt")
    val lines = s.getLines.mkString(" ")
    s.close
    lines
  }

  val tests: Tests = Tests {
    test("Wordcount test") {
      val text = getText
      val result = WordCount.countWords(text)

      result.size ==> 5 // Test number of rows

      result(1).size ==> 83
      result(2).size ==> 9
      result(3).size ==> 6
      result(4).size ==> 1
      result(9).size ==> 2

      result(4).head ==> "to"
    }
  }
}
