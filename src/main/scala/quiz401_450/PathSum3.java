package quiz401_450;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2019/4/13.
 */
public class PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumRec(root, sum) + pathSum(root.right, sum) + pathSum(root.left, sum);
    }


    private int pathSumRec(TreeNode root, int sum) {
        if (root == null) return 0;
        int newSum = sum - root.val;
        return (newSum == 0 ? 1 : 0) + pathSumRec(root.left, newSum) + pathSumRec(root.right, newSum);
    }
}
