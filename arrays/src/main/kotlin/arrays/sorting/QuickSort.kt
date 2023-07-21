package arrays.sorting

private class QuickSort {

  fun quickSort(input: IntArray): IntArray {
    if (input.size <= 1) return input

    val pivot = input[input.size - 1]
    val left = mutableListOf<Int>()
    val equal = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    for (element in input) {
      when {
        element < pivot -> left.add(element)
        element == pivot -> equal.add(element)
        element > pivot -> right.add(element)
      }
    }

    return quickSort(left.toIntArray()) + equal + quickSort(right.toIntArray())
  }
}

fun main() {
  intArrayOf(3, 4, 6, 2, 1, 5)
    .let { QuickSort().quickSort(it) }
    .let { println("Answer is: ${it.map { it }}") }
}