package dp

class HouseRobber {


  fun rob(nums: IntArray): Int {
    val size = nums.size

    if (size == 1) return nums[0]
    if (size == 2) return maxOf(nums[0], nums[1])

    val dp = Array(size) { 0 }

    dp[0] = nums[0]
    dp[1] = maxOf(nums[0], nums[1])

    for (i in 2 until size) {
      dp[i] = maxOf(dp[i - 2] + nums[i], dp[i - 1])
    }

    return dp[size - 1]
  }

}

fun main() {
  intArrayOf(2, 1, 1, 2)
    .let { HouseRobber().rob(it) }
    .let { println("Answer is: $it") }
}