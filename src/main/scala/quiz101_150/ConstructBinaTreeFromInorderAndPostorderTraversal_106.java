package quiz101_150;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2018/10/17.
 */
public class ConstructBinaTreeFromInorderAndPostorderTraversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        int rootValue = postorder[postorder.length - 1];

        TreeNode rootNode = new TreeNode(rootValue);
        int rootIndexInInorder = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {
                rootIndexInInorder = i;
                break;
            }
        }

        return rootNode;
    }
}
