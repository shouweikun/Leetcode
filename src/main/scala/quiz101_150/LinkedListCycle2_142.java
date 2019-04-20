package quiz101_150;

import Context.java.ListNode;

/**
 * Created by john_liu on 2019/4/20.
 */
public class LinkedListCycle2_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null) return null;
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
            slow = slow.next;

        } while (fast != slow);
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
