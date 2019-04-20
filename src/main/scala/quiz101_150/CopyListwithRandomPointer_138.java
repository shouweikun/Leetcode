package quiz101_150;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by john_liu on 2019/4/20.
 */
public class CopyListwithRandomPointer_138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    ;

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        Node copy = null;
        Node dummy = new Node();
        while (node != null) {
            if (copy == null) {
                copy = new Node();
                copy.val = node.val;
                dummy.next = copy;
                map.put(node, copy);

            } else {
                copy.next = new Node();
                copy.next.val = node.val;
                map.put(node, copy);
                copy = copy.next;
            }
            node = node.next;
        }
        copy = dummy.next;
        node = head;
        while (copy != null) {
            if (node.random != null) copy.random = map.get(copy.random);
            copy = copy.next;
            node = node.next;
        }
        return dummy.next;
    }


    public Node copyListWithRandomPointer(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node copyHead = new Node();
        copyHead.val = head.val;
        map.put(head, copyHead);
        for (Node p = head.next, q = copyHead; p != null; p = p.next, q = q.next) {
            q.next = new Node();
            q.next.val = p.val;
            map.put(p, q.next);
        }
        for (Node p = head, q = copyHead; p != null; p = p.next, q = q.next) {
            if (p.random != null) {
                q.random = map.get(p.random);
            }
        }
        return copyHead;
    }
}
