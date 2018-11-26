package quiz101_150;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2018/11/26.
 */
public class SumRoottoLeafNumbers_129 {
    private int count = 0;
    public int sumNumbers(TreeNode root) {
      sumNumber(root,0);
      return count;
    }
    public void sumNumber(TreeNode root, int acc) {
        if (root == null) count += acc;
        else if (isLeaf(root)) count += (acc * 10 + root.val);
        else {
            if (root.left != null) sumNumber(root.left, acc * 10 + root.val);
            if (root.right != null) sumNumber(root.right, acc * 10 + root.val);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
