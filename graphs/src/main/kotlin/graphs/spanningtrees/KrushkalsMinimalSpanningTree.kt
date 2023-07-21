package graphs.spanningtrees

import graphs.disjointset.DisjointSet
import graphs.entities.*
import graphs.input.ReadGraphFromConsole

private class KrushkalsMinimalSpanningTree
constructor(
  val graph: Graph
) {

  val output = mutableListOf<Edge>()
  val disjointSet = DisjointSet(graph)
  val includedList = Array(graph.numberOfVertices()) { false }

  fun invoke(): List<Edge> {
    val sortedEdges = graph.edges.sortedBy { it.weight }

    for (edge in sortedEdges) {
      if (disjointSet.addIfDoesntFormACycle(edge)) {
        output.add(edge)
        includedList[edge.source] = true
        includedList[edge.destination] = true
      }

      if (includedList.all { it })
        return output
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
    .let { KrushkalsMinimalSpanningTree(it).invoke() }
    .let { println("${KrushkalsMinimalSpanningTree::class.simpleName} results: $it") }
}
