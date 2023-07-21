package graphs.search

import graphs.entities.Graph
import graphs.entities.listNeighbours
import graphs.entities.numberOfVertices

class DFS
constructor(
  private val graph: Graph
){

  private val output = mutableListOf<Int>()
  private val visitedList = Array(graph.numberOfVertices()) { false }

  fun invoke(vertex: Int): List<Int> {

    if(visitedList[vertex].not()) {
      output.add(vertex)
      visitedList[vertex] = true
      graph.listNeighbours(vertex).forEach { invoke(it) }
    }

    return output
  }
}
