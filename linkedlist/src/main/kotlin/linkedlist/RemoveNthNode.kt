package linkedlist

import entities.ListNode
import input.linkedlist.PrintLinkedList
import input.linkedlist.ReadLinkedListFromConsole

class RemoveNthNode {

  fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val headNode = head

    var left = headNode
    var right = headNode

    for (i in 1..n) right = right?.next

    if (right == null) return headNode?.next

    while (right?.next != null) {
      left = left?.next
      right = right?.next
    }

    left?.next = left?.next?.next

    return headNode
  }
}

fun main() {
  ReadLinkedListFromConsole().invoke()
    .let { RemoveNthNode().removeNthFromEnd(it, 1) }
    .let { println("Answer is: ${PrintLinkedList().invoke(it)}") }

}