package graphs.search

import graphs.construct.GraphTestFactory
import org.amshove.kluent.shouldBeEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object DFSSpek : Spek({


  describe("dfs") {
    val graph = GraphTestFactory.buildUnweightedDirectedGraph()
    val result = DFS(graph).invoke(2)

    it("checks dfs") {
      result shouldBeEqualTo listOf(2, 0, 1, 3)
    }
  }
})
