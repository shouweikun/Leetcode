package quiz101_150;

import Context.java.ListNode;

/**
 * Created by john_liu on 2019/4/9.
 */
public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return sort(head, tail);
    }

    private ListNode sort(ListNode low, ListNode high) {
        if (low == high) return low;
        if (low.next == high) {
            if (low.val > high.val) {
                high.next = low;
                low.next = null;
                return high;
            }
            return low;
        }
        ListNode middle = low;
        ListNode temp = low;
        while (temp != high) {
            temp = temp.next;
            middle = middle.next;
            if (temp != high) temp = temp.next;
        }
        ListNode middleNext = middle.next;
        ListNode left = sort(low, middle);
        ListNode right = sort(middleNext, high);
        return mergeTwoLists(left, right);
    }

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


    public static void main(String[] args) {

        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        new SortList_148().sortList(l1);

    }

}
