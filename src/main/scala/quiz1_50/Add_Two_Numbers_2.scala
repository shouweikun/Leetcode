package quiz1_50

import Context.ListNode

import scala.annotation.tailrec

/**
  * Created by john_liu on 2017/10/13.
  * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
  * *
  * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  * *
  * Example
  * *
  * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
  * Output: 7 -> 0 -> 8
  * Explanation: 342 + 465 = 807.
  */
object Add_Two_Numbers_2 {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    lazy val head = new ListNode()
@tailrec
    def loopAdd(acc: ListNode = head, hasCarry: Boolean = false): Unit = {
      lazy val l1IsNull: Boolean = l1.next == null
      lazy val l2IsNull: Boolean = l2.next == null
      lazy val stackTop: Boolean = l1IsNull && l2IsNull
      if (stackTop) {
        if (hasCarry) acc.next = new ListNode(1)
      }
      else {
       lazy val nextNodeAndHasCarry =  (!l1IsNull,!l2IsNull) match {
          case (true,true) => buildNextNodeAndHasNext(l1.x,l2.x,hasCarry)
          case (true,false) => buildNextNodeAndHasNext(l1.x,0,hasCarry)
          case (false,true) => buildNextNodeAndHasNext(0,l2.x,hasCarry)
        }
        lazy val nextNode = nextNodeAndHasCarry._1
        lazy val nextHasCarry = nextNodeAndHasCarry._2

        loopAdd(nextNode,nextHasCarry)
      }

    }

    def buildNextNodeAndHasNext(left:Int = 0,right: Int = 0,hasCarry:Boolean = false):(ListNode,Boolean) = {
      lazy val carry = if(hasCarry) 1 else 0
      lazy val value = carry + left + right
      lazy val nextHasCarry = value>9
      lazy val theValue = if(nextHasCarry) value-10 else value

      (new ListNode(theValue),nextHasCarry)
    }
    loopAdd()
     head
  }

   def addTwoNumbers2(l1: ListNode, l2: ListNode): ListNode = {
    def _add(l1: ListNode, l2: ListNode, current: ListNode, temp: Int): Unit =
      if (l1 != null || l2 != null || temp != 0) {
        val (newL1, l1Val) = if (l1 != null) (l1.next, l1.x) else (null, 0)
        val (newL2, l2Val) = if (l2 != null) (l2.next, l2.x) else (null, 0)
        val sum = temp + l1Val + l2Val

        current.next = new ListNode(sum % 10)
        _add(newL1, newL2, current.next, sum / 10)
      }

    val head = new ListNode(0)
    val current = head
    _add(l1, l2,current, 0)
    head.next
  }

}
