package dp

import input.arrays.ReadStringFromConsole

//https://leetcode.com/problems/edit-distance/

class EditDistance {


  fun minDistance(word1: String, word2: String): Int {
    val size1 = word1.length
    val size2 = word2.length

    val dp = Array(size1 + 1) { Array(size2 + 1) { 0 } }

    for (i in 0..size1) dp[i][0] = i
    for (j in 0..size2) dp[0][j] = j

    for (i in 1..size1) {
      for (j in 1..size2) {
        if (word1[i - 1] == word2[j - 1]) dp[i][j] = dp[i - 1][j - 1]
        else dp[i][j] = minOf(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
      }
    }

    return dp[size1][size2]
  }
}

fun main() {
  val word1 = ReadStringFromConsole().invoke()
  val word2 = ReadStringFromConsole().invoke()

  EditDistance().minDistance(word1, word2)
    .let { println("Answer is: $it") }
}