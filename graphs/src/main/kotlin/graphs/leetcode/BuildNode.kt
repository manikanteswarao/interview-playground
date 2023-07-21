package graphs.leetcode

class BuildNode {

  fun invoke(input: List<List<Int>>): Node? {
    if (input.isEmpty()) return null

    val nodesMap: MutableMap<Int, Node> = mutableMapOf()

    val size = input.size
    for (i in 1..size) nodesMap[i] = Node(i)

    for (i in 0 until size) {
      val neighbours = input[i]
      val node = nodesMap.getValue(i + 1)

      for (neighbourVal in neighbours) {
        node.neighbors.add(nodesMap.getValue(neighbourVal))
      }
    }

    return nodesMap.getValue(1)
  }

}

fun main() {
  val adjList =
    listOf(
      listOf(2, 4),
      listOf(1, 3),
      listOf(2, 4),
      listOf(1, 3)
    )

 val node =  BuildNode().invoke(adjList)
  PrintNode().print(node)
  println("---------------------")

  val copy = CloneGraph().cloneGraph(node)
  PrintNode().print(copy)

}