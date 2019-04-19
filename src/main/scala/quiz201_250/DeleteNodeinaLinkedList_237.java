package quiz201_250;

import Context.java.ListNode;

/**
 * Created by john_liu on 2019/4/14.
 */
public class DeleteNodeinaLinkedList_237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;


    }
}

