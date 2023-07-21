package trees.others

import entities.TreeNode
import input.arrays.ReadIntFromConsole
import input.trees.ReadBinaryTreeFromConsole

class PathSum2 {

  val output: MutableList<List<Int>> = mutableListOf()

  fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    hasPathSum(root, targetSum, emptyList())
    return output
  }

  fun hasPathSum(root: TreeNode?, targetSum: Int, path: List<Int>) {
    if (root == null) return

    val remaining = targetSum - root.`val`
    val newPath = path + listOf(root.`val`)

    if (remaining == 0 && root?.left == null && root?.right == null) {
      output.add(newPath)
    }

    hasPathSum(root.left, remaining, newPath)
    hasPathSum(root.right, remaining, newPath)
  }
}


fun main() {
  val tree = ReadBinaryTreeFromConsole().invoke()
  val targetSum = ReadIntFromConsole().invoke()

  PathSum().hasPathSum(tree, targetSum)
    .let { println("Answer is: $it") }
}