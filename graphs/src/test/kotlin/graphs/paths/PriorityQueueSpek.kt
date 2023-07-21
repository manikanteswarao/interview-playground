package graphs.paths

import org.amshove.kluent.shouldBeEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.util.*

object PriorityQueueSpek : Spek({

   data class Node(
    val vertex: String,
    val weight: Int
  )

   val comparator = kotlin.Comparator<Node> { o1, o2 -> o1.weight - o2.weight }
   val priorityQueue = PriorityQueue(comparator)

  describe("PriorityQueue") {

    priorityQueue.add(Node("A", 4))
    priorityQueue.add(Node("B", 2))
    priorityQueue.add(Node("A", 1))
    priorityQueue.add(Node("B", 4))

    val result1 = priorityQueue.poll()
    val result2 = priorityQueue.poll()

    println("Result is : $result2")

    it("test") {
      result1 shouldBeEqualTo Node("A", 1)
      result2 shouldBeEqualTo Node("B", 2)
    }
  }
})
