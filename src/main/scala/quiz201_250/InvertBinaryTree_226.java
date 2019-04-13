package quiz201_250;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2019/4/10.
 */
public class InvertBinaryTree_226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        right.left = left;
        right.right = right;
        return root;
    }
}
