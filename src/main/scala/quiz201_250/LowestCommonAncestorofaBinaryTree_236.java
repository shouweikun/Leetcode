package quiz201_250;

import Context.java.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2018/12/16.
 */
public class LowestCommonAncestorofaBinaryTree_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, q, p);
        TreeNode right = lowestCommonAncestor(root.right, q, p);
        if (left != null || right != null) return root;
        return left == null ? right : left;
    }


}
