package quiz1_50

import scala.collection.mutable

/**
  * Created by john_liu on 2018/8/24.
  * '(', ')', '{', '}', '[' and ']'
  */
object ValidParentheses_20 {
  def isValid(s: String): Boolean = {
    def isMatch(left: Char, right: Char): Boolean = {
      (left, right) match {
        case ('(', ')') => true
        case ('[', ']') => true
        case ('{', '}') => true
        case _ => false
      }
    }
    val stack = new mutable.Stack[Char]
    s.toCharArray.map {
      x =>
        if (stack.isEmpty) stack.push(x)
        else if (isMatch(stack.top,x)) stack.pop() else stack.push(x)
    }
    stack.isEmpty

  }



  def main(args: Array[String]): Unit = {
    isValid("()")
  }
}
