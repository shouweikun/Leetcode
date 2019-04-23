package quiz51_100

import Context.scala.TreeNode

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Created by john_liu on 2018/9/4.
  */
object BinaryTreeInorderTraversal_94 {
  def inorderTraversal(root: TreeNode): List[Int] = {
    inorderTraversal_stack(root)
  }

  def inorderTraversal_stack(node: TreeNode): List[Int] = {
    val re = new ListBuffer[Int]
    val stack = new mutable.Stack[TreeNode]

    @tailrec
    def leftFirstLoop(curr: TreeNode): Unit = if (curr != null) {
      stack.push(curr)
      leftFirstLoop(curr.left)
    }

    @tailrec
    def loopTreeNode(theNode: TreeNode = node): Unit = {

      leftFirstLoop(theNode)
      if (stack.nonEmpty) {
        val curr = stack.pop()
        re += curr.value
        loopTreeNode(curr.right)
      }
    }

    loopTreeNode()
    re.toList
  }

  def inorderTraversal_r(root: => TreeNode): Option[List[Int]] = {
    val parent = Option(root).map(_.value)
    val left = Option(root).flatMap(r => Option(r.left)).flatMap(inorderTraversal_r(_))
    val right = Option(root).flatMap(r => Option(r.right)).flatMap(inorderTraversal_r(_))

    val a = for {
      h <- parent
      l <- if (left.isDefined) left else Option(Nil)
      r <- if (right.isDefined) right else Option(Nil)
    } yield (l ::: List(h) ::: r)

    a
  }

  def inorderTraversal_iter(root: => TreeNode): List[Int] = {
    val re = new mutable.ListBuffer[Int]
    val stack = new mutable.Stack[TreeNode]
    var curr = root
    while (curr != null || stack.nonEmpty) {
      while (curr != null) {
        stack.push(curr)
        curr = curr.left
      }
      curr = stack.pop()
      re += curr.value
      curr = curr.right
    }

    re.toList
  }

  def main(args: Array[String]): Unit = {
    lazy val root = new TreeNode(0)
    lazy val left = new TreeNode(1)
    lazy val rigth = new TreeNode(2)
    root.right = rigth;
    root.left = left
    println(inorderTraversal_r(root))
    println(inorderTraversal_stack(root))
    println(inorderTraversal_iter(root))
  }


}
