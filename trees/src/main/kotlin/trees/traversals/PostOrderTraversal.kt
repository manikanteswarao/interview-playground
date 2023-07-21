package trees.traversals

import input.trees.ReadBSTFromConsoleInput
import entities.TreeNode

private class PostOrderTraversal {

  class Recursive {
    val output = mutableListOf<Int>()

    fun invoke(node: TreeNode?): List<Int> {
      if (node != null) {
        invoke(node.left)
        invoke(node.right)
        output.add(node.`val`)
      }
      return output
    }
  }

  class Iterative {

    val output = mutableListOf<Int>()

    fun invoke(root: TreeNode?): List<Int> {
      if (root == null) return emptyList()
      val node = root

      val outStack: ArrayDeque<TreeNode> = ArrayDeque()
      val stack: ArrayDeque<TreeNode> = ArrayDeque()

      stack.addLast(node)

      while (stack.isNotEmpty()) {
        val element = stack.removeLast()
        outStack.add(element)

        val left = element.left
        if (left != null) stack.addLast(left)

        val right = element.right
        if (right != null) stack.addLast(right)
      }

      while (outStack.isNotEmpty()) {
        output.add(outStack.removeLast().`val`)
      }

      return output
    }
  }
}


fun main() {
  val bst = ReadBSTFromConsoleInput().build(listOf(5, 2, 1, 3, 6, 4, 9, 7, 10))

  PostOrderTraversal.Recursive().invoke(bst)
    .let { println("Recursive result: $it") }

  PostOrderTraversal.Iterative().invoke(bst)
    .let { println("Iterative result: $it") }
}
