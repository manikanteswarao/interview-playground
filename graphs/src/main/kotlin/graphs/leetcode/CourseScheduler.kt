package graphs.leetcode

class CourseScheduler {

  private var hasCycle: Boolean = false

  constructor()

  fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val adjList = Array(numCourses) { mutableListOf<Int>() }

    for (edge in prerequisites) adjList[edge.last()].add(edge.first())
    for (i in 0 until numCourses) {
      dfs(adjList, i, HashSet())
      println("Cycle : $hasCycle at index: $i")
    }

    return !hasCycle
  }


  private fun dfs(adjList: Array<MutableList<Int>>, nodeValue: Int, visited: HashSet<Int>): Boolean {
    if (visited.contains(nodeValue)) return true

    visited.add(nodeValue)
    for (element in adjList[nodeValue]) {
      if (dfs(adjList, element, visited))
        return true
    }

    visited.remove(nodeValue)
    return false
  }

  fun hasCycle(adjList: Array<List<Int>>): Boolean {
    val visited = BooleanArray(adjList.size) // Array to keep track of visited nodes
    val inProgress = BooleanArray(adjList.size) // Array to keep track of nodes being visited

    fun dfs(node: Int): Boolean {
      if (inProgress[node]) {
        return true // Cycle found
      }

      if (visited[node]) {
        return false // Already visited, no cycle from this node
      }

      inProgress[node] = true // Mark node as being visited

      for (nextNode in adjList[node]) {
        if (dfs(nextNode)) {
          return true // Cycle found in the sub-graph
        }
      }

      inProgress[node] = false // Mark node as visited
      visited[node] = true

      return false
    }

    for (node in adjList.indices) {
      if (!visited[node] && dfs(node)) {
        return true // Cycle found in the graph
      }
    }

    return false // No cycle found in the graph
  }


}

fun main() {
  val list = arrayOf(
    intArrayOf(1, 4),
    intArrayOf(2, 4),
    intArrayOf(3, 1),
    intArrayOf(3, 2),
  )

  CourseScheduler().canFinish(5, list)
    .let { println("Answer is: $it") }
}