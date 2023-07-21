package porter

import entities.TreeNode
import input.trees.ReadBinaryTreeFromConsole


class SecondLargestDiameter {

  private data class Result(
    val first: Int,
    val second: Int
  )

  private data class Heights(
    val first: Int,
    val second: Int
  )

  fun invoke(node: TreeNode?): Int {
    return computeResult(node).second
  }

  private fun computeResult(node: TreeNode?): Result {
    if (node == null) return Result(0, 0)

    val leftResult = computeResult(node.left)
    val rightResult = computeResult(node.right)

    val leftHeights = heights2(node.left)
    val rightHeights = heights2(node.right)

    val currentNodeDiameter =
      maxOf(
        leftResult.first,
        rightResult.first,
        leftHeights.first + 1 + rightHeights.first
      )

    val secondMax = listOf(
      leftResult.first,
      leftResult.second,
      rightResult.first,
      rightResult.second,
      currentNodeDiameter,
      leftHeights.first + 1 + rightHeights.second,
      leftHeights.second + 1 + rightHeights.first
    ).sorted().reversed()[1]

    return Result(currentNodeDiameter, secondMax)
  }


  private fun heights2(node: TreeNode?): Heights {
    if (node == null) return Heights(0, 0)

    val leftHeights = heights2(node.left)
    val rightHeights = heights2(node.right)

    val max = maxOf(leftHeights.first, rightHeights.first) + 1
    val secondMax = computeSecondHeight(leftHeights, rightHeights)
    return Heights(max, secondMax)
  }

  private fun computeSecondHeight(leftHeights: Heights, rightHeights: Heights): Int {
    return when {
      leftHeights.first != 0 && rightHeights.first != 0 -> minOf(leftHeights.first, rightHeights.first) + 1
      leftHeights.second == 0 && rightHeights.second == 0 -> 0
      leftHeights.second == 0 && rightHeights.second != 0 -> rightHeights.second + 1
      leftHeights.second != 0 && rightHeights.second == 0 -> leftHeights.second + 1
      else -> 0
    }
  }

}

fun main() {
  val input = ReadBinaryTreeFromConsole().invoke()

  val diameter = DiameterOfABinaryTree().invoke(input)
  println("Diameter of a given binary tree: $diameter")

  val result = SecondLargestDiameter().invoke(input)
  println("Second Largest Diameter of a given binary tree: $result")
}