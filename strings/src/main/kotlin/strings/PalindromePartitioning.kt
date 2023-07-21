package strings

import input.arrays.ReadStringFromConsole

class PalindromePartitioning {

  val output: MutableList<List<String>> = mutableListOf()

  fun partition(s: String): List<List<String>> {
    val size = s.length

    val dp = Array(size) { Array(size) { false } }

    for (i in 0 until size) dp[i][i] = true
    for (i in 0 until size - 1) dp[i][i + 1] = (s[i] == s[i + 1])

    for (batchSize in 2 until size) {
      for (i in 0 until size - batchSize) {
        val j = i + batchSize
        dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]
      }
    }

    split(0, size - 1, dp, mutableListOf(), s.toCharArray())
    return output
  }

  private fun split(left: Int, size: Int, dp: Array<Array<Boolean>>, path: List<String>, s: CharArray) {
    if (left > size) {
      var total = ""
      path.forEach { total += it }
      println("total: $total")
      if (total.length == size+1) {
        output.add(path)
      }
      return
    }

    for (i in left..size) {
      if (dp[left][i]) {
        var str = ""
        for (j in left..i) str += s[j]
        println("${left}--${i}-- $str")
        val newList = path + listOf(str)
        split(i + 1, size, dp, newList, s)
      }
    }

  }

}

fun main() {
  ReadStringFromConsole().invoke()
    .let { PalindromePartitioning().partition(it) }
    .map { println(it) }
}