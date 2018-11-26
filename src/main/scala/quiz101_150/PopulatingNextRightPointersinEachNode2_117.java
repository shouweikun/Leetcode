package quiz101_150;

import Context.java.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by john_liu on 2018/11/26.
 */
public class PopulatingNextRightPointersinEachNode2_117 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        TreeLinkNode cur;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 1; i <= size; i++) {
                cur = queue.poll();
                if (i < size) cur.next = queue.peek();
                else cur.next = null;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
    }
}
