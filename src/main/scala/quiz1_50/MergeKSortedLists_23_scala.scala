package quiz1_50

import Context.scala.ListNode

/**
  * Created by john_liu on 2018/8/25.
  */
object MergeKSortedLists_23_scala {
  def mergeKLists(lists: Array[ListNode]): ListNode = {
     if(lists.forall(_ == null)) return null;
     loopSort(lists)
  }

  def loopSort(list:Array[ListNode]):ListNode = {
    if(list.size==1) return list(0)
    lazy val nextList = list.filter(x=>x!=null)
    lazy val min =  nextList.minBy(_.x)
    min.next = loopSort(nextList)
    min
  }

}
