package graphs.cycles

import graphs.entities.Edge
import graphs.entities.Graph
import graphs.entities.numberOfVertices

class IsGraphHaveACycle
constructor(
  private val graph: Graph
) {

  val parentsArray = Array(graph.numberOfVertices()) { -1 }

  fun find(vertex: Int): Int {
    if (parentsArray[vertex] == -1)
      return vertex
    else
      return find(parentsArray[vertex])
  }

  fun union(edge: Edge) {
    val sourceParent = find(edge.source)
    val destinationParent = find(edge.destination)

    if (sourceParent != destinationParent) {
      parentsArray[edge.source] = edge.destination
    }
  }
}
