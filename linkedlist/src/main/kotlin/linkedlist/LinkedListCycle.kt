package linkedlist

import entities.ListNode

//https://leetcode.com/problems/linked-list-cycle/

class LinkedListCycle {

  fun hasCycle(head: ListNode?): Boolean {
    var list = head
    val visited: MutableMap<ListNode, Boolean> = mutableMapOf()

    while (list != null) {
      if (visited[list] == true) return true

      visited[list] = true
      list = list.next
    }

    return false
  }

  fun hasCycle2(head: ListNode?): Boolean {
    if (head == null) return false
    var fast = head
    var slow = head

    while(fast?.next != null) {
      fast = fast.next?.next
      slow = slow?.next

      if(fast == slow) return true
    }

    return false
  }

}