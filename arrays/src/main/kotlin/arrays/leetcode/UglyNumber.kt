package arrays.leetcode

import kotlin.math.sign

class UglyNumber {

  fun nthUglyNumber(n: Int): Int {
    var uglyNumbers = IntArray(n)

    uglyNumbers[0] = 1

    var index2 = 0
    var index3 = 0
    var index5 = 0

    for (i in 1 until n) {

      val nextUgly = minOf(
        uglyNumbers[index2] * 2,
        uglyNumbers[index3] * 3,
        uglyNumbers[index5] * 5
      )

      uglyNumbers[i] = nextUgly

      if (nextUgly == uglyNumbers[index2] * 2) index2++
      if (nextUgly == uglyNumbers[index3] * 3) index3++
      if (nextUgly == uglyNumbers[index5] * 5) index5++
    }

    return uglyNumbers[n - 1]
  }

}

fun main() {
  UglyNumber().nthUglyNumber(10)
    .let { println("Answer is: $it") }
}