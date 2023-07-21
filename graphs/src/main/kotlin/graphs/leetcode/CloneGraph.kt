package graphs.leetcode


//https://leetcode.com/problems/clone-graph/

class CloneGraph {

  private val map: MutableMap<Int, Node> = mutableMapOf()

  fun cloneGraph(node: Node?): Node? {
    if (node == null) return null

    val nodeValue = node.`val`
    val copy = Node(nodeValue)
    map[nodeValue] = copy

    for (neighbor in node.neighbors) {
      val neighborValue = neighbor?.`val`!!
      if (map[neighborValue] != null) {
        copy.neighbors.add(map[neighborValue])
      } else {
        cloneGraph(neighbor)
        copy.neighbors.add(map.getValue(neighborValue))
      }
    }

    return copy
  }

}

