package dp

import input.arrays.ReadIntArrayFromConsole

private class LongestIncreasingSubsequence {

  fun lengthOfLIS(nums: IntArray): Int {
    val size = nums.size
    val dp = Array(size) { 0 }

    for (i in 0 until size) dp[i] = 1

    for (i in 0 until size) {
      for (j in 0 until i) {

        if (nums[j] < nums[i]) {
          if (dp[i] < dp[j] + 1) dp[i] = dp[j] + 1
        }
      }
    }

    return dp.max()!!
  }
}

fun main() {
   intArrayOf(7,7,7,7,7,7,7)
    .let { LongestIncreasingSubsequence().lengthOfLIS(it) }
    .let { println("Answer is: $it") }
}
