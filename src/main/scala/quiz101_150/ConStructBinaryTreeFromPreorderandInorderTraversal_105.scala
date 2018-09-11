package quiz101_150

import Context.scala.TreeNode

/**
  * Created by john_liu on 2018/9/11.
  */
object ConStructBinaryTreeFromPreorderandInorderTraversal_105 {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    val size = preorder.size
    if (size == 0) return null
    if (size == 1) new TreeNode(preorder(0))
    else {
      val pValue = preorder(0)
      val pIndexInInorder = inorder.zipWithIndex.find(_._1 == pValue).get._2
      val leftCount = pIndexInInorder
      val left = buildTree(preorder.slice(1, leftCount+1), inorder.slice(0, leftCount))
      val right = buildTree(preorder.slice(leftCount + 1, size), inorder.slice(leftCount + 1, size))
      val re = new TreeNode(pValue)
      re.left = left
      re.right = right
      re
    }
  }

}
