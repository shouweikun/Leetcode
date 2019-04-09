package quiz1_50;

import Context.java.ListNode;

/**
 * Created by john_liu on 2019/4/9.
 */
public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;
        ListNode curr = null;
        while (l1 != null) {
            if (l2 != null) {
                ListNode temp = null;
                if (l1.val < l2.val) {
                    temp = l1;
                    l1 = l1.next;
                } else {
                    temp = l2;
                    l2 = l2.next;
                }
                if (curr != null) {
                    curr.next = temp;
                    curr = curr.next;
                } else curr = temp;
                if (head == null) head = curr;
            } else {
                curr.next = l1;
                break;
            }
            if (l1 == null) {
                l1 = l2;
                l2 = null;
            }
        }
        return head;
    }
}
