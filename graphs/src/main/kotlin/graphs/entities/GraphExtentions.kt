package graphs.entities

import graphs.construct.ConstructAdjacencyListGraph
import graphs.construct.ConstructAdjacencyMatrixGraph


fun Graph.adjacencyList() = ConstructAdjacencyListGraph().invoke(this)
fun Graph.adjacencyMatrix() = ConstructAdjacencyMatrixGraph().invoke(this)

fun Graph.numberOfVertices() =
  vertices().size

fun Graph.vertices() =
  this.edges.flatMap { listOf(it.source, it.destination) }.distinct()

fun Graph.matrixNeighbours(vertex: Int) =
  this.adjacencyMatrix()[vertex].withIndex()
    .mapNotNull {
      when {
        it.value > 0 -> it.index
        else -> null
      }
    }.sorted()


fun Graph.listNeighbours(vertex: Int) =
  this.adjacencyList()[vertex].map { it.destination }.sorted()


