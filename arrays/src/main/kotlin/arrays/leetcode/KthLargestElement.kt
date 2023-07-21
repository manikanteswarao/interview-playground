package arrays.leetcode

import java.util.PriorityQueue

class KthLargestElement {

  fun findKthLargest(nums: IntArray, k: Int): Int {
    val minHeap = PriorityQueue<Int>()

    for (num in nums) {
      minHeap.add(num)
      if (minHeap.size > k) minHeap.remove()
    }

    return minHeap.peek()
  }
}

fun main() {
  intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
    .let { KthLargestElement().findKthLargest(it, 4) }
    .let { println("Answer is: $it") }
}