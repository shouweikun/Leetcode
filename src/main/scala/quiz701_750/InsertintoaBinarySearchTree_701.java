package quiz701_750;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2019/4/15.
 */
public class InsertintoaBinarySearchTree_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left == null) root.left = new TreeNode(val);
            else insertIntoBST(root.left, val);
        } else {
            if (root.right == null) root.right = new TreeNode(val);
            else insertIntoBST(root.right, val);
        }

        return root;
    }
}
