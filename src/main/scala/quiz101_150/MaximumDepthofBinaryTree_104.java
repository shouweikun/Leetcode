package quiz101_150;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2019/4/21.
 */
public class MaximumDepthofBinaryTree_104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root
                .right));

    }
}
