package quiz151_200;

import Context.java.ListNode;

/**
 * Created by john_liu on 2018/12/14.
 */
public class IntersectionofTwoLinkedLists_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int aLength = getLinkListLength(headA);
        int bLength = getLinkListLength(headB);
        ListNode longList;
        ListNode shortList;
        int diff = aLength-bLength;
        if(diff>0){
            longList = headA;
            shortList = headB;
        } else{
            longList = headB;
            shortList = headA;
        }
        int realDiff = Math.abs(diff);
        while(realDiff>0){
            longList = longList.next;
            realDiff--;
        }
        while(shortList != null){
         if(shortList ==longList) return shortList;
         shortList = shortList.next;
         longList = longList.next;
        }
        return  null;
    }
    public int getLinkListLength(ListNode hd){
        ListNode head = hd;
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }

}
