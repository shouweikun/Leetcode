package quiz201_250;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by john_liu on 2019/4/21.
 */
public class PopulatingNextRightPointersinEachNode_116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 1; i <= size; i++) {
                Node curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
                if (pre != null) pre.next = curr;
                pre = curr;
            }
        }
        return root;
    }
}
