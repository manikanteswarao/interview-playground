package trees.traversals

import input.trees.ReadBSTFromConsoleInput
import entities.TreeNode
import java.util.*

private class LevelOrderTraversal {

  val output = mutableListOf<Int>()
  val queue = ArrayDeque<TreeNode>()

  fun invoke(node: TreeNode): List<Int> {
    queue.add(node)

    while (true) {
      val element = queue.poll()

      if (element != null) {
        output.add(element.`val`)

        if (element.left != null) queue.add(element.left)
        if (element.right != null) queue.add(element.right)
      } else break
    }
    return output
  }
}


fun main() {
  ReadBSTFromConsoleInput().invoke()
    .let { LevelOrderTraversal().invoke(it) }
    .let { println("${LevelOrderTraversal::class.simpleName} results: $it") }
}
