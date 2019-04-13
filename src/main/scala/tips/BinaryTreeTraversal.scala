package tips

import Context.scala.TreeNode

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Created by john_liu on 2018/9/5.
  */
object BinaryTreeTraversal {
  def preorderTraversal_r(root: TreeNode): List[Int] = {

    if (root == null) Nil
    else List(root.value) ::: preorderTraversal_r(root.left) ::: preorderTraversal_r(root.right)
  }

  def preorderTraversal(root: TreeNode): List[Int] = {
    val re = new ListBuffer[Int]
    val stack = new mutable.Stack[TreeNode]
    var curr: TreeNode = null
    if (root == null) return Nil else stack.push(root)
    while (stack.nonEmpty) {
      curr = stack.pop()
      re += curr.value
      Option(curr.right).map(stack.push(_))
      Option(curr.left).map(stack.push(_))
    }
    re.toList
  }

  def inorderTraversal(root: TreeNode): List[Int] = {
    val re = new ListBuffer[Int]
    val stack = new mutable.Stack[TreeNode]
    var curr = root

    while (curr != null || stack.nonEmpty) {
      while (curr != null) {
        stack.push(curr)
        curr = curr.left
      }
      curr = stack.pop()
      re += curr.value
      stack.push(curr.right)
    }
    re.toList
  }


  def inorderTraversal_r(root: TreeNode): List[Int] = {
    if (root == null) Nil
    else inorderTraversal_r(root.left) ::: List(root.value) ::: inorderTraversal_r(root.right)
  }


  def postorderTraversal_r(root: TreeNode): List[Int] = {
    if (root == null) Nil
    else postorderTraversal_r(root.left) ::: postorderTraversal_r(root.right) ::: List(root.value)
  }

  def postorderTraversal(root: TreeNode): List[Int] = {
    lazy val re = new ListBuffer[Int]
    lazy val stack = new mutable.Stack[TreeNode]
    if (root != null) {


    var curr: TreeNode = null
    var last: TreeNode = null
    stack.push(root)
    while(stack.nonEmpty) {
      curr = stack.top
      val rightIsNull = curr.right == null
      val leftIsNull = curr.left == null

      def consumeCurr = {
        re += curr.value
        stack.pop()
        last = curr
      }

      (rightIsNull, leftIsNull) match {
        case (true, true) => consumeCurr
        case (true, false) => if (last == curr.left) consumeCurr else stack.push(curr.left)
        case (false, true) => if (last == curr.right) consumeCurr else stack.push(curr.right)
        case (false, false) => if (last == curr.right) consumeCurr else {
          stack.push(curr.left)
          stack.push(curr.right)
        }
      }
    }
    }

   re.toList

  }
}
