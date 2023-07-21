package graphs.search

import org.amshove.kluent.shouldBeEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.util.*

@ExperimentalStdlibApi
object QueueSpek : Spek({


  describe("queue") {

    val queue : Queue<Int> = LinkedList()

    val result = mutableListOf<Int>()


    queue.add(0)
    queue.add(1)

    while (queue.isNotEmpty()) result.add(queue.poll())


    println("Result is: $result")

    it("checks bfs") {
      result shouldBeEqualTo listOf(0, 1)
    }
  }
})
