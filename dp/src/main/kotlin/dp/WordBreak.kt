package dp

import input.arrays.PrintMatrix

class WordBreak {

  class Recursive {

    val dp = Array(310) { Array<Boolean?>(310) { null } }

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
      return solve(s, wordDict, 0, s.length)!!
    }

    private fun solve(s: String, wordDict: List<String>, left: Int, right: Int): Boolean {
      if (left >= right) return true

      if (dp[left][right] != null) return dp[left][right]!!

      var ans = false

      for (i in left until right) {
        val word = s.substring(left, i + 1)
        if (wordDict.contains(word)) {
          ans = ans || solve(s, wordDict, i + 1, right)
        }
      }

      dp[left][right] = ans

      return ans
    }
  }

  class DP {

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
      val size = s.length
      val dp = Array(size) { Array(size) { false } }

      for (i in 0 until size) {
        for (j in 0 until i) {
          dp[0][i] = dp[0][i] || wordDict.contains(s.substring(0, i + 1)) || dp[0][j] && dp[j+1][i]
        }
      }

      PrintMatrix().invoke(dp)
      return dp[0][size - 1]
    }

  }


}

fun main() {
//  WordBreak.DP().wordBreak(
//    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
//    listOf("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")
//  )
//    .let { println("Answer is: $it") }

  WordBreak.DP().wordBreak(
    "leetcode",
    listOf("leet","code")
  ).let { println("Answer is: $it") }
}
