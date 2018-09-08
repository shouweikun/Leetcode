package quiz1_50;

import Context.java.ListNode;

/**
 * Created by john_liu on 2018/8/25.
 */
public class MergekSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
         if(lists.length ==0) return null;
        return loopMerge(lists,0,lists.length-1);
    }

    public ListNode loopMerge(ListNode[] lists,int low,int high){
        if(low == high) return lists[low];
        if(low == high -1) return merge2(lists[low],lists[high]);
        int middle = (low+high)/2;
        ListNode theLow = loopMerge(lists,low,middle);
        ListNode theHigh =loopMerge(lists,middle+1,high);
         return merge2(theHigh,theLow);
    }

    public ListNode merge2(ListNode l1,ListNode l2){
        if(l1 == null) return  l2;
        if(l2 == null) return l1;
        if(l1.val<l2.val) {
           l1.next =  merge2(l1.next,l2);
           return l1;
        }else {
            l2.next = merge2(l1,l2.next);
            return l2;
    }
}


}
