package com.github.frankivo

import utest.{TestSuite, Tests, test}

object TestBitCount extends TestSuite {
  val tests: Tests = Tests {
    test("test3") {
      val res = Perl79.getBits(3)
      val exp = 4
      assert(res == exp)
    }

    test("test4") {
      val res = Perl79.getBits(4)
      val exp = 5
      assert(res == exp)
    }
  }
}
