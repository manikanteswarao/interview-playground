package dp

import input.arrays.ReadIntFromConsole

class ClimbingStairs {

  fun climbStairs(n: Int): Int {
    val dp = IntArray(n + 1)

    if (n <= 2) return n
    dp[1] = 1
    dp[2] = 2

    for (i in 3..n) {
      dp[i] = dp[i - 1] + dp[i - 2]
    }

    return dp[n]
  }
}

fun main() {
  ReadIntFromConsole().invoke()
    .let { ClimbingStairs().climbStairs(it) }
    .let { println("Answer is: $it") }
}