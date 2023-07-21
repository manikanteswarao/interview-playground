package input.trees

import input.arrays.ReadListFromConsoleInput
import entities.TreeNode

class ReadBSTFromConsoleInput {

  fun invoke(): TreeNode {
    return ReadListFromConsoleInput().invoke()
      .let { build(it) }
  }

  fun build(input: List<Int>): TreeNode {
    var node: TreeNode? = null

    for (element in input) {
      node = add(element, node)
    }

    println()
    println("INPUT---------------------")
    PrintTree().invoke(node!!)
    println()
    println("--------------------------")
    return node!!
  }

  private fun add(element: Int, node: TreeNode?): TreeNode {
    if (node == null) return TreeNode(`val` = element)

    if (element < node.`val`)
      node.left = add(element, node.left)
    else
      node.right = add(element, node.right)

    return node
  }


}
