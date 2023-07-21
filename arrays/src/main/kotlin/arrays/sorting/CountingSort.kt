package arrays.sorting

private class CountingSort {

  fun countingSort(input: IntArray): IntArray {
    if (input.isEmpty()) {
      return input
    }

    val max = input.maxOrNull() ?: return input
    val countArray = IntArray(max + 1)

    for (element in input) {
      countArray[element]++
    }

    var outputIndex = 0
    for (i in countArray.indices) {
      while (countArray[i] > 0) {
        input[outputIndex] = i
        outputIndex++
        countArray[i]--
      }
    }

    return input
  }
}


fun main() {
  intArrayOf(3, 4, 6, 2, 1, 5)
    .let { CountingSort().countingSort(it) }
    .let { println("Answer is: ${it.map { it }}") }
}