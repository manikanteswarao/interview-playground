package input.linkedlist

import entities.ListNode

class PrintLinkedList {

  fun invoke(input: ListNode?) {
    var ll = input
    while (ll?.value != null) {
      print("-->${ll?.value}")
      ll = ll.next
    }
    println()
  }

}