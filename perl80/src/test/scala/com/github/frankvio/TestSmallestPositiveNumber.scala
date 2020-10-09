package com.github.frankvio

import utest.{ArrowAssert, TestSuite, Tests, test}

object TestSmallestPositiveNumber extends TestSuite {
  val tests: Tests = Tests {
    test("Example 1") {
      val input = "5, 2, -2, 0"
        .split(", ")
        .map(_.toInt)

      SmallestPositiveNumber.findSmallest(input) ==> 1
    }

    test("Example 2") {
      val input = "1, 8, -1"
        .split(", ")
        .map(_.toInt)

      SmallestPositiveNumber.findSmallest(input) ==> 2
    }

    test("Example 3") {
      val input = "2, 0, -1"
        .split(", ")
        .map(_.toInt)

      SmallestPositiveNumber.findSmallest(input) ==> 1
    }
  }
}
