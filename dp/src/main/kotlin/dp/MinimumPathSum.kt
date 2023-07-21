package dp

import input.arrays.ReadIntArrayFromConsole
import input.arrays.ReadIntFromConsole

class MinimumPathSum {

  fun minPathSum(grid: Array<IntArray>): Int {
    val rows = grid.size
    val columns = grid.first().size

    val sumGrid = Array(rows) { Array(columns) { 0 } }

    for (row in 0 until rows) sumGrid[row][0] = grid[row][0] + (if (row - 1 >= 0) sumGrid[row - 1][0] else 0)
    for (col in 0 until columns) sumGrid[0][col] = grid[0][col] + (if (col - 1 >= 0) sumGrid[0][col - 1] else 0)


    for (row in 1 until rows) {
      for (col in 1 until columns) {
        sumGrid[row][col] = minOf(sumGrid[row - 1][col], sumGrid[row][col - 1]) + grid[row][col]
      }
    }

    return sumGrid[rows - 1][columns - 1]
  }

}


fun main() {
  val m = ReadIntFromConsole().invoke()

  (1..m).map {
    ReadIntArrayFromConsole().invoke()
  }.let { MinimumPathSum().minPathSum(it.toTypedArray()) }
    .let { println("Answer is: $it") }
}