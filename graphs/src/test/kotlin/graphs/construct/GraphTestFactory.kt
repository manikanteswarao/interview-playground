package graphs.construct

import graphs.entities.Edge
import graphs.entities.Graph

object GraphTestFactory {

  fun buildUnweightedDirectedGraph() =
    Graph(
      weighted = false,
      directed = true,
      edges = listOf(
        Edge(0, 1, 1),
        Edge(0, 2, 1),
        Edge(1, 2, 1),
        Edge(2, 0, 1),
        Edge(2, 3, 1),
        Edge(3, 3, 1)
      )
    )
}
