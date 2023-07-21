package trees.traversals

import entities.TreeNode
import input.trees.ReadBSTFromConsoleInput


private class PreOrderTraversal {

  class Recursive {

    private val output = mutableListOf<Int>()

    fun invoke(root: TreeNode?): List<Int> {
      if (root != null) {
        output.add(root.`val`)
        invoke(root.left)
        invoke(root.right)
      }
      return output
    }
  }

  class Iterative {

    val ouput = mutableListOf<Int>()

    fun invoke(root: TreeNode?): List<Int> {
      val node = root
      val stack: ArrayDeque<TreeNode> = ArrayDeque()

      stack.addLast(node!!)

      while (stack.isNotEmpty()) {
        val element = stack.removeLast()
        ouput.add(element.`val`)

        val right = element.right
        if (right != null) stack.addLast(right)

        val left = element.left
        if (left != null) stack.addLast(left)
      }

      return ouput
    }
  }
}

fun main() {
  val bst = ReadBSTFromConsoleInput().build(listOf(5, 2, 1, 3, 6, 4, 9, 10))


  PreOrderTraversal.Recursive().invoke(bst)
    .let { println(" Recursive result: $it") }

  PreOrderTraversal.Iterative().invoke(bst)
    .let { println("Iterative result: $it") }
}
