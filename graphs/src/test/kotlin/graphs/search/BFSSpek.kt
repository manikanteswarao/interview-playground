package graphs.search

import graphs.construct.GraphTestFactory
import org.amshove.kluent.shouldBeEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

@ExperimentalStdlibApi
object BFSSpek : Spek({


  describe("bfs") {
    val graph = GraphTestFactory.buildUnweightedDirectedGraph()
    val result = BFS().invoke(graph, 2)

    it("checks bfs") {
      result shouldBeEqualTo listOf(2, 0, 3, 1)
    }
  }
})
