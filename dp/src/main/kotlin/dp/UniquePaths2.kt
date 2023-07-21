package dp

import input.arrays.ReadIntArrayFromConsole
import input.arrays.ReadIntFromConsole

//https://leetcode.com/problems/unique-paths-ii/

class UniquePaths2 {

  fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {

    val rows = obstacleGrid.size
    val columns = obstacleGrid.first().size


//    for(row in 0 until rows) {
//      if(obstacleGrid[row][0] != 1)
//    }
    TODO()
  }
}

fun main() {
  val m = ReadIntFromConsole().invoke()

  (1..m).map {
    ReadIntArrayFromConsole().invoke()
  }.let { UniquePaths2().uniquePathsWithObstacles(it.toTypedArray()) }
    .let { println("Answer is: $it") }
}