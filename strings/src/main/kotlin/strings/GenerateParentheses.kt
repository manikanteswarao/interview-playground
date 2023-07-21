package strings

private class GenerateParentheses {

  class Recursion {
    val output = mutableListOf<String>()

    fun generateParenthesis(n: Int): List<String> {
      generate("", 0, 0, n)
      return output
    }

    private fun generate(str: String, leftCount: Int, rightCount: Int, n: Int) {
      if (leftCount == n && rightCount == n) output.add(str)

      if (leftCount < n)
        generate("$str(", leftCount + 1, rightCount, n)
      if (rightCount < leftCount)
        generate("$str)", leftCount, rightCount + 1, n)
    }
  }

  class DP {
    fun generateParenthesis(n: Int): List<String> {
      if (n <= 0) {
        return emptyList()
      }

      val dp = Array(n + 1) { mutableListOf<String>() }
      dp[0].add("")

      for (i in 1..n) {
        for (j in 0 until i) {
          for (str1 in dp[j]) {
            for (str2 in dp[i - j - 1]) {
              dp[i].add("($str1)$str2")
            }
          }
        }
      }

      return dp[n]
    }
  }


}


fun main() {
  GenerateParentheses.DP().generateParenthesis(3)
    .let { println("Answer is: $it") }
}