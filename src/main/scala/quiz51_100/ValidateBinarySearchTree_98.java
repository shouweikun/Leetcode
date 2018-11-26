package quiz51_100;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2018/11/26.
 */
public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long downer, long upper) {
        if (root == null) return true;
        boolean left = (root.left != null) ? ((root.val > root.left.val && root.left.val > downer) ? true : false) : true;
        boolean right = (root.right != null) ? ((root.val < root.right.val && root.right.val < upper) ? true : false) : true;
        if (!(left && right)) return false;
        left = isValidBST(root.left, downer, root.val);
        right = isValidBST(root.right, root.val, upper);
        return left && right;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(20);
    }

}
