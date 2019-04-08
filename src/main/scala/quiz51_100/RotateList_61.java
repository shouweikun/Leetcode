package quiz51_100;

import Context.java.ListNode;

/**
 * Created by john_liu on 2019/4/8.
 */
public class RotateList_61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        ListNode start = head;
        ListNode pivot = head;
        ListNode re = null;
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        k = k % length;
        for (int i = 0; i < k; i++) {
            pivot = pivot.next;
        }
        while (pivot.next != null) {
            pivot = pivot.next;
            start = start.next;
        }
        if (start.next == null) {
            re = head;
        } else {
            re = start.next;
            start.next = null;
            pivot.next = head;
        }


        return re;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        new RotateList_61().rotateRight(l1, 2);
    }
}
