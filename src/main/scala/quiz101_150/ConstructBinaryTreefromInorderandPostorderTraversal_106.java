package quiz101_150;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2019/4/21.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        return recBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode recBuildTree(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2) {
        if (start1 > end1) return null;
        if (start1 == end1) return new TreeNode(inorder[start1]);
        int headValue = postorder[end2];
        int headIndexInOrder = start1;
        for (; headIndexInOrder <= end1; headIndexInOrder++) {
            if (inorder[headIndexInOrder] == headValue) break;
        }
        int leftLength = headIndexInOrder - start1;
        TreeNode left = recBuildTree(inorder, start1, headIndexInOrder - 1, postorder, start2, start2 + leftLength - 1);
        int rightLength = end1 - headIndexInOrder;
        TreeNode right = recBuildTree(inorder, headIndexInOrder + 1, end1, postorder, end2 - rightLength, end2 - 1);
        TreeNode re = new TreeNode(headValue);
        re.left = left;
        re.right = right;
        return re;
    }
}
