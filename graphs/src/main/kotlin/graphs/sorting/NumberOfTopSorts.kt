package graphs.sorting

import graphs.entities.Graph
import graphs.entities.listNeighbours
import graphs.entities.numberOfVertices
import java.util.*

class NumberOfTopSorts
constructor(
  private val graph: Graph
) {

  private val queue: Queue<Int> = LinkedList()

  private val multiplesArray = mutableListOf<Int>()

  fun invoke(): Int {
    val inDegree = getInDegree()

    inDegree.forEachIndexed { index, i -> if (i == 0) queue.add(index) }

    multiplesArray.add(queue.size)

    var sortedList = mutableListOf<Int>()
    val numberOfNodes = graph.numberOfVertices()

    while (queue.isNotEmpty()) {
      val currentVertex = queue.poll()

      sortedList.add(currentVertex)


      val neighboursWithInDegreeZero = mutableListOf<Int>()
      graph.listNeighbours(currentVertex).forEach { neighbour ->
        inDegree[neighbour] -= 1
        if (inDegree[neighbour] == 0) neighboursWithInDegreeZero.add(neighbour)
      }


      if(neighboursWithInDegreeZero.size > 0) multiplesArray.add(neighboursWithInDegreeZero.size)

      neighboursWithInDegreeZero.forEach { queue.add(it) }
    }

    if (numberOfNodes != sortedList.size) error("Topological sort is not possible")

    return multiplesArray.reduce { acc, i -> acc * i }
  }


  private fun getInDegree(): Array<Int> {
    val inDegreeList = Array(graph.numberOfVertices()) { 0 }
    graph.edges.forEach { inDegreeList[it.destination] += 1 }
    return inDegreeList
  }
}
