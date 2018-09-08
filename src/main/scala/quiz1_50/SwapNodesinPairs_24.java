package quiz1_50;

import Context.java.ListNode;

/**
 * Created by john_liu on 2018/8/28.
 */
public class SwapNodesinPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if(head ==null || head.next ==null) return head;

        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode next = swapPairs(node2.next);
        node2.next = node1;
        node1.next = next;
        return node2;
    }
}
