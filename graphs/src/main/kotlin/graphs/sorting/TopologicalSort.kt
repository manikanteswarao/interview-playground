package graphs.sorting

import graphs.entities.Graph
import graphs.entities.listNeighbours
import graphs.entities.numberOfVertices
import java.util.*

class TopologicalSort
constructor(
  private val graph: Graph
) {


  private val queue: Queue<Int> = LinkedList()

  fun invoke(): List<Int> {
    val inDegree = getInDegree()

    inDegree.forEachIndexed { index, i -> if (i == 0) queue.add(index) }

    var sortedList = mutableListOf<Int>()
    val numberOfNodes = graph.numberOfVertices()

    while (queue.isNotEmpty()) {
      val currentVertex = queue.poll()

      sortedList.add(currentVertex)

      graph.listNeighbours(currentVertex).forEach { neighbour ->
        inDegree[neighbour] -= 1

        if (inDegree[neighbour] == 0) queue.add(neighbour)
      }
    }

    if (numberOfNodes != sortedList.size) error("Topological sort is not possible")

    return sortedList
  }


  private fun getInDegree(): Array<Int> {
    val inDegreeList = Array(graph.numberOfVertices()) { 0 }
    graph.edges.forEach { inDegreeList[it.destination] += 1 }
    return inDegreeList
  }
}
