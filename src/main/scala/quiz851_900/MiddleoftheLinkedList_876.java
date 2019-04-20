package quiz851_900;

import Context.java.ListNode;

/**
 * Created by john_liu on 2019/4/20.
 */
public class MiddleoftheLinkedList_876 {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = head;
        ListNode eventual = head;
        int count = 1;
        while (eventual.next != null) {
            eventual = eventual.next;
            count++;
            middle = middle.next;
            if (eventual.next != null) {
                eventual = eventual.next;
                count++;
            }
        }
        return  middle;
    }
}
