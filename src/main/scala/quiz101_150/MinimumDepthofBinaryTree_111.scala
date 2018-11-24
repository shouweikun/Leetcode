package quiz101_150

import Context.scala.TreeNode

/**
  * Created by john_liu on 2018/11/23.
  */
object MinimumDepthofBinaryTree_111 {

  def minDepth(root: TreeNode): Int = {
    if(root == null) return 0;
    val hasLeft = root.left != null
    val hasRight = root.right != null
    (hasLeft, hasRight) match {
      case (true, true) => math.min(minDepth(root.left), minDepth(root.right)) + 1
      case (false, true) => minDepth(root.right)+1
      case (true, false) => minDepth(root.left) + 1
      case _ => 1
    }
  }
}
