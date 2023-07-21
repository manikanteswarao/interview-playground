package dp

import input.arrays.PrintMatrix

private class LongestPalindromicSubsequence {

  fun longestPalindromeSubseq(s: String): Int {
    val size = s.length
    val dp = Array(size) { Array(size) { 0 } }

    for (i in s.indices) dp[i][i] = 1

    for (batch in 1 until size) {
      for (i in 0 until size - batch) {
        val j = i + batch
        if (s[i] == s[j]) {
          dp[i][j] = dp[i + 1][j - 1] + 2
        } else
          dp[i][j] = maxOf(dp[i + 1][j], dp[i][j - 1])
      }
    }

    PrintMatrix().invoke(dp)
    return dp[0][size - 1]
  }

  fun invoke(s: String): String {
    val size = s.length
    val dp = Array(size) { Array(size) { "" } }

    for (i in s.indices) dp[i][i] = s[i].toString()

    for (batch in 1 until size) {
      for (i in 0 until size - batch) {
        val j = i + batch
        if (s[i] == s[j]) {
          dp[i][j] = s[i] + dp[i + 1][j - 1] + s[j]
        } else
          dp[i][j] = if(dp[i + 1][j].length > dp[i][j - 1].length) dp[i + 1][j] else dp[i][j - 1]
      }
    }

    PrintMatrix().invoke(dp)
    return dp[0][size - 1]
  }
}

fun main() {
  LongestPalindromicSubsequence().invoke("aacabdkacaait")
    .let { println("Answer is: $it") }
}
