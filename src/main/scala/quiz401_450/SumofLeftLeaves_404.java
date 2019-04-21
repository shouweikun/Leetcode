package quiz401_450;

import Context.java.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by john_liu on 2019/4/21.
 */
public class SumofLeftLeaves_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int re = 0;
        TreeNode curr = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            re += queue.peek().val;
        }

        return re;

    }

    public int sumOfLeftLeaves_2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int re = 0;
        TreeNode curr = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                    if (curr.left.left == null && curr.left.right == null) re += curr.left.val;
                }
                if (curr.right != null) queue.offer(curr.right);
            }
        }

        return re;
    }
}



