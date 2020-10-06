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

      result.foreach(r => { // Test word-count per number
        r._1 match {
          case 1 => r._2.size ==> 83
          case 2 => r._2.size ==> 9
          case 3 => r._2.size ==> 6
          case 4 => r._2.size ==> 1
          case 9 => r._2.size ==> 2
          case _ => throw new Exception("Unexpected result")
        }
      })
    }
  }
}
