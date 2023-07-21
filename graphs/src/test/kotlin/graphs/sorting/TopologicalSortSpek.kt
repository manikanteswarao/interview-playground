package graphs.sorting

import graphs.entities.Edge
import graphs.entities.Graph
import org.amshove.kluent.shouldBeEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object TopologicalSortSpek : Spek({

  val graph =
    Graph(
      directed = true,
      weighted = false,
      edges = listOf(
        Edge(5, 2, 1),
        Edge(5, 0, 1),
        Edge(4, 0, 1),
        Edge(4, 1, 1),
        Edge(2, 3, 1),
        Edge(3, 1, 1)
      )
    )

  describe("TopologicalSort") {
    val result = TopologicalSort(graph).invoke()

    result shouldBeEqualTo listOf(4,5,0,2,3,1)
  }

})
