package graphs.construct

import graphs.entities.Graph
import graphs.entities.numberOfVertices

class ConstructAdjacencyMatrixGraph {


  fun invoke(graph: Graph): Array<Array<Int>> {

    val size = graph.numberOfVertices()

    val adjacencyMatrix = Array(size) { Array(size) { 0 } }

    for (edge in graph.edges) {
      adjacencyMatrix[edge.source][edge.destination] = edge.weight

      if(graph.directed.not()) adjacencyMatrix[edge.destination][edge.source] = edge.weight
    }

    return adjacencyMatrix
  }


}
