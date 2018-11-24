package quiz101_150

import Context.scala.TreeNode

/**
  * Created by john_liu on 2018/11/23.
  */
object BalancedBinaryTree_110 {
  def isBalanced(root: TreeNode): Boolean = {
    if (root == null) return true
    getDepthOrIsNotBalanced(root) != -1
  }

  def getDepthOrIsNotBalanced(node: TreeNode): Int = {
    val left = Option(node.left).map(getDepthOrIsNotBalanced(_)).getOrElse(0)
    val right = Option(node.right).map(getDepthOrIsNotBalanced(_)).getOrElse(0)
    if (left == -1 || right == -1) return -1;
    if (math.abs(left - right) <= 1) math.max(left, right) + 1 else -1
  }


  def isBalanced2(root: TreeNode): Boolean = {
    if (root == null) return true
    getDepthOrIsNotBalanced2(root) != -1
  }

  def getDepthOrIsNotBalanced2(node: TreeNode): Int = {
    val left = if (node.left != null) getDepthOrIsNotBalanced(node) else 0
    val right = if(node.right !=null) getDepthOrIsNotBalanced(node) else 0
    if (left == -1 || right == -1) return -1;
    if (math.abs(left - right) <= 1) math.max(left, right) + 1 else -1
  }


}
