package arrays.sorting

import input.arrays.ReadIntArrayFromConsole

private class BubbleSort {

  /*
  Algo:
  1. Compares every two adjacent elements and swaps then if needed
  2. After each iteration the highest value will be bubbled to end of the array
  3.  If no swap happened in first pass, then it is already a sorted array

  Best case: O(n)
  Worst case: O(n^2)
  Average case: O(n^2)
  Useful to check if the array is already sorted.
   */

  fun invoke(input: IntArray): IntArray {
    val size = input.size

    for (pass in size - 1 downTo 0) {
      for (i in 0 until pass) {
        if (input[i] > input[i + 1]) {
          val temp = input[i]
          input[i] = input[i + 1]
          input[i + 1] = temp
        }
      }
    }

    return input
  }
}

fun main() {
  ReadIntArrayFromConsole().invoke()
    .let { BubbleSort().invoke(it) }
    .let { println("Answer is: ${it.map { it }}") }
}