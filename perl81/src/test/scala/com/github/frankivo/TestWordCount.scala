package com.github.frankivo

import utest.{ArrowAssert, TestSuite, Tests, test}

object TestWordCount extends TestSuite {
  def getText(filename: String): String = {
    val s = scala.io.Source.fromFile("src/test/resources/" + filename)
    val lines = s.getLines.mkString(" ")
    s.close
    lines
  }

  val tests: Tests = Tests {
    test("Quick Brown Fox") {
      val text = getText("QuickBrownFox.txt")
      val result = WordCount.countWords(text)

      println(result)

      result.size ==> 1 // Test number of rows
      assert(result.head._2.toSeq.contains("fox"))
    }

    test("West Side Story") {
      val text = getText("WestSideStory.txt")
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
