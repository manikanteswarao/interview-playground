package trees.traversals

import entities.TreeNode

class HeightOfATree {

  fun invoke(node: TreeNode): Map<TreeNode, Int> {
    TODO()
  }

  private fun height(node: TreeNode?): Int {
    return when (node) {
      null -> 0
      else -> maxOf(height(node.left), height(node.right)) + 1
    }
  }


}
