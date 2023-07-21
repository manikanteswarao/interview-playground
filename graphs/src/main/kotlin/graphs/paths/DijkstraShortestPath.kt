package graphs.paths

import graphs.entities.Graph
import graphs.entities.adjacencyList
import graphs.entities.numberOfVertices
import java.util.*

class DijkstraShortestPath
constructor(
  private val graph: Graph
) {

  private val numberOfVertices = graph.numberOfVertices()
  private val distance = Array(numberOfVertices) { Int.MAX_VALUE }
  private val listGraph = graph.adjacencyList()
  private val visited = Array(numberOfVertices) { false }
  private val path = Array(numberOfVertices) { -1 }

  private val comparator = kotlin.Comparator<Node> { o1, o2 -> o1.weight - o2.weight }
  private val priorityQueue = PriorityQueue(comparator)

  fun invoke(sourceVertex: Int): DijkstraResult {

    // Init
    distance[sourceVertex] = 0
    priorityQueue.add(Node(sourceVertex, 0))

    while (priorityQueue.isNotEmpty()) {

      val currentNode = priorityQueue.poll()

      visited[currentNode.vertex] = true

      listGraph[currentNode.vertex].forEach { neighbour ->

        val newDist = distance[currentNode.vertex] + neighbour.weight

        if (visited[neighbour.destination].not() && newDist < distance[neighbour.destination]) {

          path[neighbour.destination] = currentNode.vertex
          distance[neighbour.destination] = newDist
          priorityQueue.add(Node(neighbour.destination, newDist))
        }
      }
    }

    return DijkstraResult(distance = distance.toList(), path = path.toList())
  }
}


private data class Node(
  val vertex: Int,
  val weight: Int
)


