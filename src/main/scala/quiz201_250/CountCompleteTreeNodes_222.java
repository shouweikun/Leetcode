package quiz201_250;

import Context.java.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by john_liu on 2019/4/8.
 */
public class CountCompleteTreeNodes_222 {
    public int countNodes(TreeNode root) {

        if (root == null) return 0;
        int height = getHeight(root);
        int count = leafCount(root, height);
        //   System.out.println(String.valueOf(height));
        // System.out.println(String.valueOf(count));
        return ((1 << height) - 1) - ((1 << (height - 1)) - count);
    }

    private int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    private int leafCount(TreeNode root, int height) {

        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int currHeight = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            // System.out.println(String.valueOf(queue.size()));
            currHeight++;
            if (currHeight == height) return queue.size();
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode t = queue.poll();

                if (t.left != null) {

                    queue.offer(t.left);
                }
                if (t.right != null) {

                    queue.offer(t.right);
                }

            }

        }

        return 0;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        int a = new CountCompleteTreeNodes_222().leafCount(treeNode1, 3);
        System.out.println("");

    }
}
