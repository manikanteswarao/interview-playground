package trees.others

import entities.TreeNode
import input.arrays.ReadIntFromConsole
import input.trees.ReadBinaryTreeFromConsole

//https://leetcode.com/problems/path-sum/

class PathSum {

  fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false

    val remaining = targetSum - root.`val`
    if (remaining == 0 && root?.left == null && root?.right == null) return true

    return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining)
  }
}


fun main() {
  val tree = ReadBinaryTreeFromConsole().invoke()
  val targetSum = ReadIntFromConsole().invoke()

  PathSum().hasPathSum(tree, targetSum)
    .let { println("Answer is: $it") }
}