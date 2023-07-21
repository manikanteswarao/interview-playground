package arrays.sorting

private class BucketSort {

  fun bucketSort(input: IntArray): IntArray {
    if (input.isEmpty()) {
      return input
    }

    val minValue = input.minOrNull() ?: return input
    val maxValue = input.maxOrNull() ?: return input
    val bucketSize = 5

    val bucketCount = ((maxValue - minValue) / bucketSize) + 1
    val buckets = Array(bucketCount) { mutableListOf<Int>() }

    for (element in input) {
      val bucketIndex = (element - minValue) / bucketSize
      buckets[bucketIndex].add(element)
    }

    val sortedArray = mutableListOf<Int>()
    for (bucket in buckets) {
      insertionSort(bucket)
      sortedArray.addAll(bucket)
    }

    return sortedArray.toIntArray()
  }

  fun insertionSort(bucket: MutableList<Int>) {
    for (i in 1 until bucket.size) {
      val key = bucket[i]
      var j = i - 1

      while (j >= 0 && bucket[j] > key) {
        bucket[j + 1] = bucket[j]
        j--
      }

      bucket[j + 1] = key
    }
  }


}

fun main() {
  intArrayOf(5, 9, 1, 3, 2, 8, 4, 7, 6)
    .let { BucketSort().bucketSort(it) }
    .let { println("Answer is: ${it.map { it }}") }
}