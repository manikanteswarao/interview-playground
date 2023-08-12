package `in`.mani.interview

class ShipItDecider {

  data class Ballot(
    val votes: List<String>
  )

  //Ballot1: A, B, C
  //Ballot2: B, A, D

  //Ouput: A, B, C, D OR A, B, D, C

  data class Node(
    val name: String,
    val array: IntArray,
    var points: Int
  )

  private val store = mutableMapOf<String, Node>()
  private val size: Int = 3

  fun invoke(input: List<Ballot>): List<Node> {

    input.forEach { ballot ->
      ballot.votes.forEachIndexed { index, name ->
        if (store[name] == null) {
          val array = IntArray(size) { 0 }
          array[index] = 1
          store[name] = Node(name, array, getPoints(index))
        } else {
          val node = store[name]!!
          node.array[index]++
          node.points = node.points + getPoints(index)
        }
      }
    }

    val comporator = Comparator<Node> { n1, n2 -> bias(n1, n2, 0) }
    val nodes: List<Node> = store.values.toList()

    return nodes.sortedWith(comporator)
      .also { it.map { println(it) } }
  }

  private fun bias(n1: Node, n2: Node, index: Int): Int {
    if (n1.points != n2.points) return n2.points - n1.points
    if (index > size) return 0

    return if (n1.array[index] != n1.array[index]) bias(n1, n2, index + 1)
    else n2.array[index] - n1.array[index]
  }

  private fun getPoints(index: Int): Int = size - index
}


fun main() {
  val useCase = ShipItDecider()

  val ballots = listOf(
    ShipItDecider.Ballot(listOf("A", "B", "C")),
    ShipItDecider.Ballot(listOf("B", "A", "D")),
    ShipItDecider.Ballot(listOf("E", "D", "B")),
    ShipItDecider.Ballot(listOf("D", "B")),
    ShipItDecider.Ballot(listOf("A", "C", "D"))
    )


  useCase.invoke(ballots)
}

