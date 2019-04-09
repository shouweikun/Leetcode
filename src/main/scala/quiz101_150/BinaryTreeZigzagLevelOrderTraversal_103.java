package quiz101_150;

import Context.java.TreeNode;

import java.util.*;

/**
 * Created by john_liu on 2019/4/9.
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        boolean isEven = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 1; i <= size; i++) {
                TreeNode curr = isEven ? queue.pollLast():queue.pollLast();
                temp.add(curr.val);
                if (isEven) {
                    if (curr.left != null) queue.offerFirst(curr.left);
                    if (curr.right != null) queue.offerFirst(curr.right);

                } else {
                    if (curr.left != null) queue.offerLast(curr.left);
                    if (curr.right != null) queue.offerLast(curr.right);
                }
            }
            res.add(temp);
            isEven = !isEven;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left =treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

      new BinaryTreeZigzagLevelOrderTraversal_103().zigzagLevelOrder(treeNode1);
    }
}
