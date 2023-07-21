package trees.input

import entities.TreeNode
import input.trees.ReadBSTFromConsoleInput
import java.util.ArrayDeque


class PrintTree {

  val markerNode = TreeNode(`val` = -1)
  val queue = ArrayDeque<TreeNode>()

  fun invoke(node: TreeNode) {

    queue.add(node)
    queue.add(markerNode)

    while (queue.isNotEmpty()) {
      val element = queue.poll()


      if (element == markerNode) {
        if (queue.isEmpty()) break
        else {
          queue.add(markerNode); println(" ")
        }
      } else {
        print("  ${element.`val`} ")

        if (element.left != null) queue.add(element.left)
        if (element.right != null) queue.add(element.right)
      }
    }
  }
}

fun main() {
  ReadBSTFromConsoleInput().invoke()
    .let { PrintTree().invoke(it) }
}

