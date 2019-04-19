package quiz101_150;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2019/4/15.
 */
public class BalancedBinaryTreeJava_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
