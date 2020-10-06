package com.github.frankivo

import utest.{TestSuite, Tests, test}

object TestTrappedRainWater extends TestSuite {
  val tests: Tests = Tests {
    test("Example1") {
      val result = TrappedRainWater.getAmount(Array(2, 1, 4, 1, 2, 5))
      val expected = 6
      assert(expected == result)
    }

    test("Example2") {
      val result = TrappedRainWater.getAmount(Array(3, 1, 3, 1, 1, 5))
      val expected = 6
      assert(expected == result)
    }

    test("Breakstuff") {
      val result = TrappedRainWater.getAmount(Array(3, 1, 5, 1, 2, 3, 2, 2, 6))
      val expected = 4
      assert(expected == result)
    }
  }
}
