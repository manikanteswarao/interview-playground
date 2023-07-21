package arrays.sorting

import input.arrays.ReadIntArrayFromConsole

class IsSortedArray {

  fun invoke(input: IntArray): Boolean = when {
    input.isEmpty() -> true
    input.size < 2 -> true
    else -> isSorted(input)
  }

  private fun isSorted(input: IntArray): Boolean {
    var previous = input.first()

    for (index in 1 until input.size) {
      val current = input[index]
      if (current - previous < 0) return false
      previous = current
    }

    return true
  }
}

fun main() {
  ReadIntArrayFromConsole().invoke()
    .let { IsSortedArray().invoke(it) }
    .let { println("Answer is: $it") }
}