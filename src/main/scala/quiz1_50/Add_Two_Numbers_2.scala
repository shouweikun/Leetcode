package quiz1_50

import Context.ListNode

/**
  * Created by john_liu on 2017/10/13.
  */
object Add_Two_Numbers_2 {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
     var dummyhead = new ListNode
     var movement  = dummyhead
     var carryflag = 0
     while(l1.next!= null && l2.next != null){
       val sum = l1._x + l2._x + carryflag
       carryflag =if(sum > 9) 1 else 0
       val newnode = if(sum > 9) new ListNode(sum-10) else new ListNode(sum)
        movement.next =newnode
        movement = movement.next
     }
    (l1.next,l2.next) match {
      case (null,_)    =>{
        remainloop(l2.next)
      }
      case (_,null)    =>{
        remainloop(l1.next)
      }
    }
    if(carryflag ==1)movement.next = new ListNode(1)
     def remainloop(list:ListNode) ={
       while(list.next != null){
         val sum = list._x + carryflag
         carryflag =if(sum > 9) 1 else 0
         val newnode = if(sum > 9) new ListNode(sum-10) else new ListNode(sum)
         movement.next =newnode
         movement = movement.next
       }
     }
     dummyhead.next
  }
}


