package arrays.sorting

private class InsertionSort {

  /*
  Algo:
  1. Every iteration inserts the element in its correct place.
  2. For every iteration of (0 to i), find the index such that A[j] > A[i] and swap
  2. At every index i, iterate down to j till v > A[j]

  Best case: O(n^2)
  Worst case: O(n^2)
  Average case: O(n^2)
  Space complexity: O(1)
  Useful to check if the array is already sorted.
   */

  fun invoke(input: IntArray): IntArray {
    val size = input.size

    for (i in 1 until size) {
      val currentValue = input[i]
      var j = i - 1
      while (j >= 0 && input[j] > currentValue) {
        input[j + 1] = input[j]
        j--
      }
      input[j + 1] = currentValue
    }

    return input
  }
}

fun main() {
  intArrayOf(3, 4, 6, 2, 1, 5)
    .let { InsertionSort().invoke(it) }
    .let { println("Answer is: ${it.map { it }}") }
}