package trees.bst

import entities.TreeNode
import input.trees.ReadBSTFromConsoleInput

class IsValidBST {

  fun isValidBST(root: TreeNode?): Boolean {
    return invoke(root)
      .let { isSorted(it.toIntArray()) }
  }

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


  private fun isSorted(input: IntArray): Boolean {
    var previous = input.first()

    for (index in 1 until input.size) {
      val current = input[index]
      if (current <= previous ) return false
      previous = current
    }

    return true
  }
}

fun main() {
  ReadBSTFromConsoleInput().invoke()
    .let { IsValidBST().isValidBST(it) }
    .let { println("Answer is: $it") }
}
