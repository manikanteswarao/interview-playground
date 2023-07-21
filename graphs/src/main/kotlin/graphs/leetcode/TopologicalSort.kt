package graphs.leetcode

import java.util.HashSet

class TopologicalSort {

  val result = mutableListOf<Int>()
  val visited: HashSet<Node> = hashSetOf()

  fun topologicalSort(node: Node?): List<Int> {
    dfs(node)
    return result
  }

  fun dfs(node: Node?) {
    if (node == null || node in visited) return
    visited.add(node)
    for (neighbor in node.neighbors) dfs(neighbor)
    result.add(0, node.`val`)
  }
}

fun main() {
  val node1 = Node(1)
  val node2 = Node(2)
  val node3 = Node(3)

  node1.neighbors.add(node2)
  node2.neighbors.add(node3)

  val result = TopologicalSort().topologicalSort(node1)
  println(result) // Output: [1, 2, 3]
}

