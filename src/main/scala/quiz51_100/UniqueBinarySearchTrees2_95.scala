package quiz51_100

import Context.scala.TreeNode


/**
  * Created by john_liu on 2018/9/4.
  */
object UniqueBinarySearchTrees2_95 {
  def generateTrees(n: Int): List[TreeNode] = {
    if (n == 1) {List(new TreeNode(1))} else {
       val left = generateTrees(n-1).map{l =>l.left = new TreeNode(n);l}
       val right = generateTrees(n-1).map{r=>r.right = new TreeNode(n);r}
       left ::: right
    }

    def generateTrees(n:Int):List[TreeNode] = {
    ???
    }
    ???
  }


  def main(args: Array[String]): Unit = {
    generateTrees(3)
  }
}
