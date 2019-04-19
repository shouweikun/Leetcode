package quiz401_450;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2019/4/18.
 */
public class DeleteNodeinaBST_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) root.right = deleteNode(root.right, key);
        else if (root.val > key) root.left = deleteNode(root.left, key);
        return null;
    }
}
