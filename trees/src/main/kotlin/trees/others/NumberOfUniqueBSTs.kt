package trees.others

import entities.TreeNode
import input.arrays.ReadIntFromConsole
import trees.input.PrintInOrderTree

class NumberOfUniqueBSTs {

  fun generateTrees(n: Int): List<TreeNode?> {
    return generate(1, n)
  }

  private fun generate(start: Int, end: Int): List<TreeNode?> {
    if (start > end) return listOf(null)
    if (start == end) return listOf(TreeNode(start))

    val output: MutableList<TreeNode> = mutableListOf()

    for (i in start..end) {
      val leftTrees = generate(start, i - 1)
      val rightTrees = generate(i + 1, end)

      for (j in leftTrees.indices) {
        for (k in rightTrees.indices) {
          val root = TreeNode(i)
          root.left = leftTrees[j]
          root.right = rightTrees[k]

          output.add(root)
        }
      }
    }
    return output
  }


}

fun main() {
  ReadIntFromConsole().invoke()
    .let { NumberOfUniqueBSTs().generateTrees(it) }
    .map {
      println()
      PrintInOrderTree().invoke(it!!)
    }
}


