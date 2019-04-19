package quiz601_650;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2019/4/17.
 */
public class MergeTwoBinaryTrees_614 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        TreeNode root = null;
        if (t1 == null) root = t2;
        else if (t2 == null) root = t1;
        else {
            t1.val += t2.val;
            root = t1;
        }
        TreeNode left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        TreeNode right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        root.left = left;
        root.right = right;
        return root;
    }
}
