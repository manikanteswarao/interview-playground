package graphs.leetcode

class PrintNode {

  val visited: HashSet<Int> = hashSetOf()

  fun print(node: Node?) {
    if (node == null) return
    visited.add(node.`val`)

    for (neighbour in node.neighbors) {
      println("${node.`val`} ---> ${neighbour?.`val`}")
    }

    for (neighbour in node.neighbors) {
      if(!visited.contains(neighbour?.`val`)) print(neighbour)
    }
  }

}