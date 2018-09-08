package quiz1_50;

import Context.java.ListNode;

/**
 * Created by john_liu on 2018/8/24.
 */
public class RemoveNthNodeFromEndofList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pioneer = head;
        ListNode toBeRemoved = head;
        ListNode last = null;
        for (int i = 1; i < n; i++) {
            pioneer = pioneer.next;
            if (pioneer == null) return null;
        }

        while (pioneer.next != null) {
            last = toBeRemoved;
            pioneer = pioneer.next;
            toBeRemoved = toBeRemoved.next;
        }
        if(last == null ){
            return toBeRemoved.next;
        }
        last.next = toBeRemoved.next;
        toBeRemoved.next = null;
        return head;
    }
}
