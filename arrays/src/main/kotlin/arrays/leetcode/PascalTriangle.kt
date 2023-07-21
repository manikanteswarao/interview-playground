package arrays.leetcode

class PascalTriangle {

  fun generate(numRows: Int): List<List<Int>> {
    val output = mutableListOf<List<Int>>()

    for (i in 0 until numRows) {
      val currentRow = (0..i).map { j ->
        if (j == 0 || j == i) 1
        else output[i - 1][j - 1] + output[i - 1][j]
      }
      output.add(currentRow)
    }

    return output
  }
}

fun main() {
  PascalTriangle().generate(5)
    .let { it.map { println(it) } }
}