package quiz500_550;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2019/4/13.
 */
public class ConvertBSTtoGreaterTree_538 {

    public TreeNode convertBST(TreeNode root) {
        recConvert(root, 0);
        return root;
    }

    private int recConvert(TreeNode root, int acc) {
        if (root == null) return acc;
        int right = recConvert(root.right, acc);
        int curr = right + root.val;
        root.val = curr;
        return recConvert(root.left, curr);
    }
}
