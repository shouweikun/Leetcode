package quiz500_550;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2019/4/24.
 */
public class DiameterofBinaryTree_543 {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] re = new int[1];
        findMax(root, re);
        return re[0];
    }

    private int findMax(TreeNode root, int[] re) {
        if (root == null) return 0;
        int left = findMax(root.left, re);
        int right = findMax(root.right, re);
        re[0] = Math.max(re[0], left + right);
        return Math.max(left, right) + 1;
    }
}
