package arrays.leetcode

import input.arrays.ReadIntArrayFromConsole

//https://leetcode.com/problems/3sum/

class ThreeSum {

  fun threeSum(nums: IntArray): List<List<Int>> {
    val output: MutableList<List<Int>> = mutableListOf()
    val sortedArray = nums.sorted()
    val size = nums.size

    var i = 0
    while (i < size - 2) {
      var j = i + 1
      var k = size - 1

      while (j < k) {
        val sum = sortedArray[i] + sortedArray[j] + sortedArray[k]

        if (sum == 0) {
          output.add(listOf(sortedArray[i], sortedArray[j], sortedArray[k]))

          while (j + 1 < k && sortedArray[j] == sortedArray[j + 1]) j++
          while (k - 1 > j && sortedArray[k] == sortedArray[k - 1]) k--

          j++
          k--
        } else if (sum < 0) j++
        else k--
      }

      while (i < size - 2 && sortedArray[i] == sortedArray[i + 1]) i++
      i++
    }

    return output
  }
}

fun main() {
  ReadIntArrayFromConsole().invoke()
    .let { ThreeSum().threeSum(it) }
    .let { println("Answer is: $it") }
}

