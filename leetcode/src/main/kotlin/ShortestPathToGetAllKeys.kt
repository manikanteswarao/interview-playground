class ShortestPathToGetAllKeys {

  //https://leetcode.com/problems/shortest-path-to-get-all-keys/description/


  companion object {
    private val EMPTY_CELL = '.'
    private val WALL = '#'
    private val START = '@'
  }

  fun shortestPathAllKeys(grid: Array<String>): Int {


    val numberOfRows = grid.first().length

    // all rows should have same size
    assert(grid.all { it.length == numberOfRows })

    val numberOfColumns = grid.size
    val numberOfKeys = grid.sumOf { it.filter { isKey(it) }.length }

    val visitedGrid = grid.map {  }


    TODO()
  }

  fun traverse(grid: Array<String>, row: Int, col: Int, collectedKeys: Int) {

  }

  fun isKey(char: Char) : Boolean {
    return char.isLowerCase()
  }

  fun isLock(char: Char) : Boolean {
    return char.isUpperCase()
  }

}
