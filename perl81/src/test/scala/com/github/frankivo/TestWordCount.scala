package com.github.frankivo

import utest.{ArrowAssert, TestSuite, Tests, test}

object TestWordCount extends TestSuite {
  val tests: Tests = Tests {
    test("Wordcount test") {
      val text =
        """
          |West Side Story
          |
          |The award-winning adaptation of the classic romantic tragedy "Romeo and Juliet".
          |The feuding families become two warring New York City gangs, the white Jets led by Riff and the Latino Sharks, led by Bernardo.
          |Their hatred escalates to a point where neither can coexist with any form of understanding.
          |But when Riff's best friend (and former Jet) Tony and Bernardo's younger sister Maria meet at a dance, no one can do anything to stop their love.
          |Maria and Tony begin meeting in secret, planning to run away.
          |Then the Sharks and Jets plan a rumble under the highway--whoever wins gains control of the streets.
          |Maria sends Tony to stop it, hoping it can end the violence.
          |It goes terribly wrong, and before the lovers know what's happened, tragedy strikes and doesn't stop until the climactic and heartbreaking ending.
          |""".stripMargin

      val result = WordCount.countWords(text)

      result.length ==> 5 // Test number of rows

      result.foreach(r => { // Test word-count per number
        r._1 match {
          case 1 => r._2.length ==> 84
          case 2 => r._2.length ==> 9
          case 3 => r._2.length ==> 6
          case 4 => r._2.length ==> 1
          case 9 => r._2.length ==> 2
          case _ => throw new Exception("Unexpected result")
        }
      })
    }
  }
}
