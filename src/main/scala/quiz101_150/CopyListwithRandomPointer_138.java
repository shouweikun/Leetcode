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
                copy.random = node.random;
                map.put(node, copy);

            } else {
                copy.next = new Node();
                copy.next.val = node.val;
                copy.random = node.random;
                map.put(node, copy);
                copy = copy.next;
            }
            node = node.next;
        }
        copy = dummy.next;
        while (copy != null) {
            if (copy.random != null) copy.random = map.get(copy.random);
        }
        return dummy.next;
    }
}
