package quiz101_150;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2018/11/24.
 */
public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum &&root.left == null&&root.right == null) return true;
        int nextSum = sum - root.val;
        if (root.left != null && hasPathSum(root.left, nextSum)) return true;
        if (root.right != null && hasPathSum(root.right, nextSum)) return true;
        return false;
    }
}
