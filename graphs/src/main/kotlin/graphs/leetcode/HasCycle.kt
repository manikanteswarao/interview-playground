package graphs.leetcode

class HasCycle(
  private val adjList: Array<List<Int>>
) {

  private val checked = BooleanArray(adjList.size) // Array to keep track of visited nodes
  private val visited = BooleanArray(adjList.size) // Array to keep track of nodes being visited

  fun hasCycle(): Boolean {
    for (node in adjList.indices) if (!checked[node] && dfs(node)) return true

    return false
  }

  // Idea is same node can not be reached twice in same DFS
  private fun dfs(node: Int): Boolean {
    if (visited[node]) return true
    if (checked[node]) return false

    visited[node] = true

    for (nextNode in adjList[node]) if (dfs(nextNode)) return true

    visited[node] = false
    checked[node] = true

    return false
  }

}

fun main() {
  val adjList =
    arrayOf(
      listOf(1, 2),
      listOf(3, 2),
      listOf(3),
      listOf()
    )

  HasCycle(adjList).hasCycle()
    .let { println("Answer is: $it") }

}