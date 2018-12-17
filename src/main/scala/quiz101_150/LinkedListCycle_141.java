package quiz101_150;

import Context.java.ListNode;

/**
 * Created by john_liu on 2018/12/12.
 */
public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode once = head.next;
        ListNode twice = head.next.next;
        while (true) {
            if (once == twice) return true;
            once = once.next;
            if (twice == null) return false;
            twice = twice.next;
            if (twice == null) return false;
            twice = twice.next;
        }
    }
}
