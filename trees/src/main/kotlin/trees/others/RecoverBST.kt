package trees.others

import com.sun.source.tree.Tree
import entities.TreeNode

class RecoverBST {

  var previous: TreeNode? = null
  var first: TreeNode? = null
  var second: TreeNode? = null

  fun inorderTraversal(root: TreeNode?): List<Int> {
    if (root != null) {
      inorderTraversal(root.left)

      if(previous != null && previous!!.`val` > root.`val`)
      inorderTraversal(root.right)
    }

   TODO()
  }


}