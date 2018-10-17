package quiz101_150

import Context.scala.TreeNode

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.reflect.ClassTag

/**
  * Created by john_liu on 2018/9/8.
  */
object BinaryTreeLevelOrderTraversal2_107 {
  def levelOrderBottom(root: TreeNode): List[List[Int]] = {
//    val a = root.getClass
//    val b = Class[TreeNode].getClass
//
//    val c= classOf[TreeNode]
//    val d = ClassTag[TreeNode](c)


     val stack = new mutable.Stack[List[Int]]
    if(root == null) return Nil
    var list =  List[TreeNode](root)
    val re = new ListBuffer[List[Int]]
    while(list.nonEmpty){
      stack.push(list.map(_.value))
      list =list.flatMap{
        x=>List(x.left,x.right)
      }.filterNot(x=>x==null)
    }
    while(stack.nonEmpty){
       re+=stack.pop()
    }
re.toList
  }


}
