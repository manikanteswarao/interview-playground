package trees.traversals

import entities.TreeNode
import input.trees.ReadBSTFromConsoleInput

class InOrderTraversal {

  class Recursive {
    private val output = mutableListOf<Int>()

    fun invoke(root: TreeNode?): List<Int> {
      if (root != null) {
        invoke(root.left)
        output.add(root.`val`)
        invoke(root.right)
      }
      return output
    }
  }

  class Iterative {

    fun invoke(root: TreeNode?): List<Int> {
      var node = root
      val output: MutableList<Int> = mutableListOf()
      if (node == null) return output

      val stack: ArrayDeque<TreeNode?> = ArrayDeque()

      while (stack.isNotEmpty() || node != null) {
        while (node != null) {
          stack.addLast(node)
          node = node.left
        }

        node = stack.removeLast()
        output.add(node?.`val`!!)
        node = node?.right
      }

      return output
    }
  }
}


fun main() {
  ReadBSTFromConsoleInput().invoke()
    .let { InOrderTraversal.Recursive().invoke(it) }
    .map { println("--${it}--") }
}
