package quiz51_100

import Context.scala.TreeNode

/**
  * Created by john_liu on 2018/9/8.
  */
object SameTree_100 {
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if(p==null && q== null) return true;
    val currSame = Option(p).map(_.value) == Option(q).map(_.value)
    lazy val leftSame =
      if (p.left == null) q.left == null
      else if (q.left != null) q.left.value == p.left.value && isSameTree(p.left, q.left) else false
    lazy val rightSame = if (p.right == null) q.right == null
    else if (q.right != null) q.right.value == p.right.value && isSameTree(p.right, q.right) else false

      currSame && leftSame && rightSame
  }
}
