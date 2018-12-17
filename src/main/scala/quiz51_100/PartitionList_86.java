package quiz51_100;

import Context.java.ListNode;

/**
 * Created by john_liu on 2018/12/14.
 */
public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode less = null;
        ListNode more = null;
        ListNode equal = null;
        ListNode re = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val > x) {
                if (more == null) more = curr;
                else {
                    more.next = curr;
                    more = curr;
                }
            }

            if (curr.val == x) {
                equal = curr;
            }

            if (curr.val < x) {
                if (less == null) {
                    less = curr;
                    re = curr;
                } else {
                    less.next = curr;
                    less = curr;
                }
            }
          curr =   removeThisNode(curr);
        }
        int num = (less == null?0:100)+(equal == null?0:10)+(more == null?0:1);
        switch (num){
            case 111|110 :less.next = equal;equal.next = more; return re;
            case 101|100: less.next = more;return re;
            case 011 : equal.next = more;return equal;
            case 010: return equal;
            case 001: return more;
            default:return null;
        }

    }

    public ListNode removeThisNode(ListNode node) {
       ListNode re = node.next;
       node.next = null;
       return re;
    }

}
