package arrays.leetcode

import arrays.input.ReadIntArrayFromConsole
import arrays.seraching.BinarySearch

class IntegerRecitation {

  fun invoke(input: IntArray, element: Int): Int {
    val indexOfTheElement = BinarySearch().invoke(input, element) ?: return 0

    return 1 +
      countToLeft(input, indexOfTheElement - 1, element) +
      countToRight(input, indexOfTheElement + 1, element)
  }

  private fun countToLeft(input: IntArray, index: Int, element: Int): Int {
    var counter = 0
    var iterator = index

    while (iterator >= 0 && input[iterator] == element) {
      counter += 1
      iterator -= 1
    }
    return counter
  }

  private fun countToRight(input: IntArray, index: Int, element: Int): Int {
    var counter = 0
    var iterator = index

    while (iterator < input.size && input[iterator] == element) {
      counter += 1
      iterator += 1
    }
    return counter
  }
}

fun main() {
  val input = ReadIntArrayFromConsole().invoke()
  println("Please enter element to be counted")
  val element = readLine()!!.toInt()

  val count = IntegerRecitation().invoke(input, element)

  println("Given element is found $count times")
}

