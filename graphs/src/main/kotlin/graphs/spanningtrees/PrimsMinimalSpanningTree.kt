package graphs.spanningtrees

import graphs.entities.*
import graphs.input.ReadGraphFromConsole

private class PrimsMinimalSpanningTree
constructor(
  val graph: Graph
) {

  val output = mutableListOf<Edge>()
  val adjacencyList = graph.adjacencyList()
  val includedList = Array(graph.numberOfVertices()) { false }
  val vertices = graph.vertices()


  fun invoke(): List<Edge> {

    val currentVertex = graph.edges.first().source
    includedList[currentVertex] = true

    while (includedList.any { it.not() }) {

     val minCutEdge =
       vertices
        .filter { includedList[it] }
        .flatMap { adjacencyList.get(it) }
        .filter { includedList[it.destination].not() }
        .minBy { it.weight }!!

      output.add(minCutEdge)

      includedList[minCutEdge.destination] = true
    }

    return output
  }


  /*
         0

        3   4

     1    1    2

       11     7

          3


   0 1 3 0 2 4 1 3 11 2 3 7 0 3 1

   0 1 3 0 2 4 13 6
   */

}

fun main() {
  ReadGraphFromConsole().invoke()
    .let { PrimsMinimalSpanningTree(it).invoke() }
    .let { println("${PrimsMinimalSpanningTree::class.simpleName} results: $it") }
}
