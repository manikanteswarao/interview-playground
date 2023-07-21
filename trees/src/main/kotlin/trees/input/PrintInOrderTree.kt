package trees.input

import entities.TreeNode

class PrintInOrderTree {

  fun invoke(root: TreeNode?) {
    if (root != null) {
      invoke(root.left)
      print("-- ${root.`val`} -- ")
      invoke(root.right)
    }
  }
}