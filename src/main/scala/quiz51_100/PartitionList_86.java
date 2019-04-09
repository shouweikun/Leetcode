package quiz51_100;

import Context.java.ListNode;

/**
 * Created by john_liu on 2018/12/14.
 */
public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode less = new ListNode(-1);
        ListNode equal = new ListNode(-1);
        ListNode gt = new ListNode(-1);
        ListNode lessP = less;
        ListNode equalP = equal;
        ListNode gtP = gt;
        ListNode pre = null;
        while (head != null) {
            if (head.val == x) {
                equalP.next = head;
                equalP = equalP.next;
            }
            if (head.val < x) {
                lessP.next = head;
                lessP = lessP.next;
            }
            if (head.val > x) {
                gtP.next = head;
                gtP = gtP.next;
            }
            head = head.next;
        }
        if (gtP != null) gtP.next = null;
        if (equalP != null) equalP.next = null;
        if (lessP != null) lessP.next = null;

        if (less.next != null) head = less.next;
        else if (equal.next != null) head = equal.next;
        else head = gt.next;

        if (equal.next != null) equalP.next = gt.next;
        else equal.next = gt.next;

        if (less.next != null) lessP.next = equal.next;
        return head;
    }

    public ListNode partition2(ListNode head, int x) {
        if (head == null) return null;
        ListNode less = new ListNode(-1);
        ListNode gte = new ListNode(-1);
        ListNode lessP = less;
        ListNode gteP = gte;
        ListNode pre = null;
        while (head != null) {
            if (head.val < x) {
                lessP.next = head;
                lessP = lessP.next;
            } else {
                gteP.next = head;
                gteP = gteP.next;
            }
            head = head.next;
        }
        if (gteP != null) gteP.next = null;
        if (lessP != null) lessP.next = null;
        head = less.next != null ? less.next : gte.next;
        if (less.next != null) lessP.next = gte.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        new PartitionList_86().partition(l1, 3);
    }
}
