package graphs.construct

import graphs.entities.Edge
import graphs.entities.Graph

class ConstructAdjacencyListGraph {

  fun invoke(graph: Graph): List<List<Edge>> {

    val adjacencyList: ArrayList<ArrayList<Edge>> = ArrayList()

    graph.edges.indices.forEach { adjacencyList.add(it, ArrayList())  }

    graph.edges.forEach { edge ->
      adjacencyList[edge.source].add(edge)
      if(graph.directed.not()) adjacencyList[edge.destination].add(edge)
    }

    return adjacencyList
  }
}
