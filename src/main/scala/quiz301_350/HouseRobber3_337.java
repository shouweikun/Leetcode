package quiz301_350;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2018/11/26.
 */
public class HouseRobber3_337 {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int ll = (left != null) ? rob(left.left) : 0;
        int lr = (left != null) ? rob(left.right) : 0;
        int rl = (right != null) ? rob(right.left) : 0;
        int rr = (right != null) ? rob(right.right) : 0;
        int rootAndGrandChild = root.val + ll + lr + rl + rr;
        int sons = rob(left) + rob(right);

        return Math.max(rootAndGrandChild, sons);
    }


}
