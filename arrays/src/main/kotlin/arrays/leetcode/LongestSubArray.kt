package arrays.leetcode

import input.arrays.ReadIntArrayFromConsole

class LongestSubArray {

  fun longestSubArray(nums: IntArray): Int {

    var startOfTheWindowIndex = 0
    var maxSize = 0
    var numberOfZero = 0

    for (currentIndex in 0 until nums.size) {
      if (nums[currentIndex] == 0) numberOfZero++

      while (numberOfZero > 1) {
        if (nums[startOfTheWindowIndex] == 0) numberOfZero--
        startOfTheWindowIndex++
      }

      if (maxSize < currentIndex - startOfTheWindowIndex) maxSize = currentIndex - startOfTheWindowIndex
    }

    return maxSize
  }
}

fun main() {
  ReadIntArrayFromConsole().invoke()
    .let { LongestSubArray().longestSubArray(it) }
    .let { println("Answer is: $it") }
}
