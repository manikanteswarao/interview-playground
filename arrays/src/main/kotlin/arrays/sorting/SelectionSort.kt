package arrays.sorting

import input.arrays.ReadIntArrayFromConsole

class SelectionSort {

  /*
  Algo:
  1.From start index to end index, At every index i, find the min value in the rest of (i+1, n) array and swap
  2.

  Best case: O(n^2)
  Worst case: O(n^2)
  Average case: O(n^2)
  Space complexity: O(1)
  Useful to check if the array is already sorted.
   */

  fun invoke(input: IntArray): IntArray {
    val size = input.size

    for (i in 0 until size - 1) {
      var minIndex = i

      for (j in i + 1 until size) {
        if (input[j] < input[minIndex]) minIndex = j
      }

      val temp = input[i]
      input[i] = input[minIndex]
      input[minIndex] = temp
    }

    return input
  }
}

fun main() {
  ReadIntArrayFromConsole().invoke()
    .let { SelectionSort().invoke(it) }
    .let { println("Answer is: ${it.map { it }}") }
}