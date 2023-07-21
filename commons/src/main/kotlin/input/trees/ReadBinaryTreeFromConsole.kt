package input.trees

import entities.TreeNode


class ReadBinaryTreeFromConsole {

  fun invoke(): TreeNode {
    val rootNode = TreeNode(1, null, null)
    val tree = buildTree(rootNode)
    PrintTree().invoke(tree)
    println()
    return tree
  }

  private fun buildTree(node: TreeNode): TreeNode {
    val lc = readLC(node.`val`)
    if (lc != null) node.left = TreeNode(lc, null, null)
    val rc = readRC(node.`val`)
    if (rc != null) node.right = TreeNode(rc, null, null)

    if (node.left != null) buildTree(node.left!!)
    if (node.right != null) buildTree(node.right!!)
    return node
  }

  private fun readLC(node: Int): Int? {
    println("Enter Left Child for $node")
    return readNode()
  }

  private fun readRC(node: Int): Int? {
    println("Enter Right Child for $node")
    return readNode()
  }

  private fun readNode(): Int? {
    val input = readLine()!!
    return if (input.isBlank()) null
    else input.toInt()
  }
}

fun main() {
  val tree = ReadBinaryTreeFromConsole().invoke()
  PrintTree().invoke(tree)
}