package graphs.input

import graphs.entities.Edge
import graphs.entities.Graph

class ReadGraphFromConsole {

  fun invoke(): Graph {
    println(
      """ 
    Hello! Which of the following graph you want to input
    0) Weighted Directed
    1) Unweighted Directed
    2) Weighted Undirected
    3) Unweighted Undirected
  """.trimIndent()
    )

    return when (readLine()!!.toInt()) {
      0 -> readWeightedDirectedGraph()
      1 -> readUnweightedDirectedGraph()
      2 -> readWeightedUndirectedGraph()
      3 -> readUnweightedUndirectedGraph()
      else -> throw Exception("Invalid Input")
    }
  }


  private fun readWeightedDirectedGraph(): Graph {
    println("Alright! Enter source destination weight sequence separated by spaces...")

    return readArray()
      .chunked(3)
      .map { Edge(source = it[0], destination = it[1], weight = it[2]) }
      .let { Graph(edges = it, weighted = true, directed = true) }
  }

  private fun readUnweightedDirectedGraph(): Graph {
    println("Alright! Enter source destination sequence separated by spaces...")

    return readArray()
      .chunked(2)
      .map { Edge(source = it[0], destination = it[1], weight = 1) }
      .let { Graph(edges = it, weighted = false, directed = true) }
  }

  private fun readWeightedUndirectedGraph(): Graph {
    println("Alright! Enter source destination weight sequence separated by spaces...")

    return readArray()
      .chunked(3)
      .map { Edge(source = it[0], destination = it[1], weight = it[2]) }
      .let { Graph(edges = it, weighted = true, directed = false) }
  }

  private fun readUnweightedUndirectedGraph(): Graph {
    println("Alright! Enter source destination sequence separated by spaces...")

    return readArray()
      .chunked(2)
      .map { Edge(source = it[0], destination = it[1], weight = 1) }
      .let { Graph(edges = it, weighted = false, directed = false) }
  }


  private fun readArray() =
    readLine()!!
      .split(" ")
      .filterNot { it.isEmpty() }
      .map(String::toInt)

}
