package arrays.sorting

private class MergeSort {

  fun mergeSort(input: IntArray): IntArray {
    val size = input.size
    if (size <= 1) return input

    val middle = size / 2
    val leftSubArray = input.copyOfRange(0, middle)
    val rightSubArray = input.copyOfRange(middle, size)

    mergeSort(leftSubArray)
    mergeSort(rightSubArray)

    return merge(mergeSort(leftSubArray), mergeSort(rightSubArray))
  }

  fun merge(left: IntArray, right: IntArray): IntArray {
    val leftSize = left.size
    val rightSize = right.size

    val merge = IntArray(leftSize + rightSize)

    var l = 0
    var r = 0
    var m = 0

    while (l < leftSize && r < rightSize) {
      if (left[l] <= right[r]) merge[m++] = left[l++]
      else merge[m++] = right[r++]
    }

    while (l < leftSize) merge[m++] = left[l++]
    while (r < rightSize) merge[m++] = right[r++]

    return merge
  }


}

fun main() {
  intArrayOf(3, 4, 6, 2, 1, 5)
    .let { MergeSort().mergeSort(it) }
    .let { println("Answer is: ${it.map { it }}") }
}