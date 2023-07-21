package graphs.paths

import graphs.entities.Edge
import graphs.entities.Graph
import org.amshove.kluent.shouldBe
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object DijkstraSpek : Spek({
  
  describe("dijkstra") {

    val graph =
      Graph(
        directed = true,
        weighted = true,
        edges = listOf(
          Edge(0, 1, 4),
          Edge(0, 2, 1),
          Edge(2, 1, 2),
          Edge(1, 4, 4),
          Edge(2, 3, 4),
          Edge(3, 4, 4)
        )
      )


    val result = DijkstraShortestPath(graph).invoke(0)

    println("Result: $result")


    it("test") {
      result.distance[4] shouldBe  7
    }

  }
})
