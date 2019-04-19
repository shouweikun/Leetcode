package quiz101_150;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2019/4/15.
 */
public class MinimumDepthofBinaryTree_java_110 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDepthInternal(root);
    }

    private int minDepthInternal(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        int min = Integer.MAX_VALUE;
        if (root.right != null) min = Math.min(min, minDepthInternal(root.right));
        if (root.left != null) min = Math.min(min, minDepthInternal(root.left));
        return min+1;
    }
}
