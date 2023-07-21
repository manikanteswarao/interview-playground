package graphs.search

import graphs.entities.*
import graphs.input.ReadGraphFromConsole
import java.util.*

class BFS {

  private val output = mutableListOf<Int>()
  private val queue : Queue<Int> = LinkedList()

  fun invoke(graph: Graph, startVertex: Int): List<Int> {

    val visitedList = Array(graph.numberOfVertices()) { false }
    queue.add(startVertex)

    while (queue.isNotEmpty()) {
      val currentVertex = queue.poll()

      if (currentVertex != null) {
        output.add(currentVertex)
        visitedList[currentVertex] = true


        graph.listNeighbours(currentVertex)
          .forEach { neighbour ->
          if (visitedList[neighbour].not()) {
            queue.add(neighbour)
          }
        }
      }
    }


    println("OUTPUT is $output")
    return output
  }
}
