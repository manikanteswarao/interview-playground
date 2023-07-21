package porter

class NumberOfIslands {

  fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty() || grid.first().isEmpty()) return 0

    var count = 0
    for (i in grid.indices) {
      for (j in grid.first().indices) {
        if (grid[i][j] == '1') {
          count++
          dfs(grid, i, j)
        }
      }
    }
    return count

  }

  private fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
    if (i < 0 || j < 0 || i >= grid.size || j >= grid.first().size || grid[i][j] != '1') return

    grid[i][j] = '#'
    dfs(grid, i, j + 1)
    dfs(grid, i, j - 1)
    dfs(grid, i + 1, j)
    dfs(grid, i - 1, j)
  }

}
