import entities.ListNode
import input.linkedlist.ReadLinkedListFromConsole

class AddTwoNumbers {

  fun invoke(l1: ListNode?, l2: ListNode?): ListNode? {
    var firstInput = l1
    var secondInput = l2

    var list: ListNode? = null
    var head : ListNode? = null
    var carryForward = 0

    while (firstInput?.value != null || secondInput?.value != null  ) {
      val sum = (firstInput?.value ?: 0) + (secondInput?.value ?: 0) + carryForward

      val take = sum % 10
      carryForward = if(sum >= 10) 1 else 0

//      println("sum: $sum, take: $take, forward: $carryForward")
      val newNode = ListNode(take)

      if (list == null) {
        list  = newNode
        head = list
      }
      else {
        list.next = newNode
        list = list.next
      }

      firstInput = firstInput?.next
      secondInput = secondInput?.next
    }

    if(carryForward == 1) list?.next = ListNode(1)
    return head
  }
}



fun main() {
  val x = ReadLinkedListFromConsole().invoke()
  val y = ReadLinkedListFromConsole().invoke()

  AddTwoNumbers().invoke(x, y)
    .let { ReadLinkedListFromConsole().printLL(it) }
}


//fun main() {
//  val x = 10
//  println("${x.toString().takeLast(1)}")
//  println("${x.toString().take(1)}")
//}