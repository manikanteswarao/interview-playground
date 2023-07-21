import input.arrays.ReadStringFromConsole

class LongestPalindromicSubstring {

  fun invoke(s: String): String {

    if (s.isEmpty()) return ""

    val input = s.toCharArray()
    val size = s.length
    var globalMaxSize = 0
    var globalMaxOutput = ""

    val grid = Array(size + 1) { IntArray(size + 1) { 0 } }

    for (batchSize in 0 until size - 1) {
      for (i in 0 until size) {
        val j = i + batchSize

        if (j >= size) continue

        if (i == j) grid[i][j] = 1
        else if (input[i] == input[j] && grid[i + 1][j - 1] == j - i - 1) grid[i][j] = grid[i + 1][j - 1] + 2
        else grid[i][j] = maxOf(grid[i + 1][j], grid[i][j - 1])

        if (grid[i][j] > globalMaxSize) {
          globalMaxSize = grid[i][j]
          if (i == j) globalMaxOutput = input[i].toString()
          else globalMaxOutput = s.substring(i, j + 1)
        }
      }
    }
    return globalMaxOutput
  }
}


fun main() {
  ReadStringFromConsole().invoke()
    .let { LongestPalindromicSubstring().invoke(it) }
    .let { println("Answer is: $it") }
}