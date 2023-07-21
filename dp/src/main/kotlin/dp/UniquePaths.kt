package dp

import input.arrays.ReadIntFromConsole

//https://leetcode.com/problems/unique-paths/

class UniquePaths {

  fun uniquePaths(m: Int, n: Int): Int {
    val paths = Array(m) { Array(n) { 0 } }

    for (i in 0 until m) paths[i][0] = 1
    for (j in 0 until n) paths[0][j] = 1

    for (i in 1 until m) {
      for (j in 1 until n) {
        paths[i][j] = paths[i - 1][j] + paths[i][j - 1]
      }
    }

    return paths[m - 1][n - 1]
  }
}

fun main() {
  val m = ReadIntFromConsole().invoke()
  val n = ReadIntFromConsole().invoke()

  UniquePaths().uniquePaths(m, n)
    .let { println("Answer is: $it") }
}

