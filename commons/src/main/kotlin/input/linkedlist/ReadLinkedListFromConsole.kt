package input.linkedlist

import entities.ListNode

class ReadLinkedListFromConsole {

  fun invoke(): ListNode {
    println("Hello! Enter the array elements with spaces and then press enter...")
    return readLine()!!
      .split(" ")
      .filterNot { it.isEmpty() }
      .map(String::toInt)
      .let { buildLL(it)!! }
      .also { printLL(it) }
  }

  private fun buildLL(input: List<Int>): ListNode? {
    var list: ListNode? = null
    var head: ListNode? = null

    input.forEach { number ->
      val newNode = ListNode(number)
      if (list == null) {
        list = ListNode(number)
        head = list
      } else {
        list?.next = newNode
        list = list?.next
      }
    }

    return head
  }

  fun printLL(input: ListNode?) {
    var ll = input
    while (ll?.value != null) {
      print("-->${ll?.value}")
      ll = ll.next
    }
    println()
  }
}


fun main() {
  ReadLinkedListFromConsole().invoke()
}