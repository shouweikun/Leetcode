package quiz101_150;

import Context.java.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by john_liu on 2018/11/26.
 */
public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.right == null && root.left == null) return true;
        if ((root.right == null) ^ (root.left == null)) return false;
        Deque<TreeNode> deque1 = new LinkedList<>();
        Deque<TreeNode> deque2 = new LinkedList<>();
        Deque<TreeNode> deque;
        Deque<TreeNode> nextDeque;
        Deque<TreeNode> temp;
        deque1.offer(root.left);
        deque1.offer(root.right);
        deque = deque1;
        nextDeque = deque2;
        TreeNode first;
        TreeNode last;
        int size;
        while (!deque.isEmpty()) {
            size = deque.size();
            if (size % 2 != 0) return false;
            while (!deque.isEmpty()) {
                first = deque.removeFirst();
                last = deque.removeLast();
                if ((first == null) ^ (last == null)) return false;
                if (first != null && last != null) {
                    if (first.val != last.val) return false;
                }
                if (first != null) nextDeque.offerLast(first.left);
                else nextDeque.offerLast(null);
                if (first != null) nextDeque.offerLast(first.right);
                else nextDeque.offerLast(null);
                if (last != null) nextDeque.offerLast(last.left);
                else nextDeque.offerLast(null);
                if (last != null) nextDeque.offerLast(last.right);
                else nextDeque.offerLast(null);
            }
            temp = nextDeque;
            nextDeque = deque;
            deque = temp;
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> deque1 = new LinkedList<>();
        Deque<TreeNode> deque2 = new LinkedList<>();
        deque1.offerLast(root.left);
        deque2.offerLast(root.right);
        TreeNode left, right;
        while (!deque1.isEmpty()) {
            left = deque1.poll();
            right = deque2.poll();
            if ((left == null) ^ (right == null)) return false;
            if (left == null && right == null) continue;
            if (left.val != right.val) return false;
            deque1.offerLast(left.left);
            deque2.offerLast(right.right);
            deque1.offerLast(left.right);
            deque2.offerLast(right.left);
        }
        return true;
    }
}
