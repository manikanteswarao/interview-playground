package porter

import entities.TreeNode


/*

Find the diameter of a given binary tree.
The diameter of a tree is the number of nodes on the longest path between two leaf nodes.
Extension: Find second largest diameter of a binary tree.

 */


class DiameterOfABinaryTree {

  fun invoke(node: TreeNode?) =
    diameter(node)

  private fun diameter(node: TreeNode?): Int {
    if (node == null) return 0

    val leftChildDiameter = diameter(node.left)
    val rightChildDiameter = diameter(node.right)

    val currentNodeDiameter = height(node.left) + height(node.right) + 1

    return maxOf(leftChildDiameter, rightChildDiameter, currentNodeDiameter)
  }

  private fun height(node: TreeNode?): Int = when (node) {
    null -> 0
    else -> maxOf(height(node.left), height(node.right)) + 1
  }
}

