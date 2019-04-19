package quiz101_150;

import Context.java.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2018/11/25.
 */
public class FlattenBinaryTreetoLinkedList_114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (isLeafOrIsNull(root.left) && isLeafOrIsNull(root.right)) terminalFlatten(root);
        else {
            flatten(root.left);
            flatten(root.right);
            terminalFlatten(root);
        }
    }

    private boolean isLeafOrIsNull(TreeNode n) {
        return n == null || (n.left == null && n.right == null);
    }

    private void terminalFlatten(TreeNode node) {
        if (node == null) return;
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.right = left;
        if (left != null) {
            node.left = null;
            TreeNode temp = node.right;
            while (temp.right != null) temp = temp.right;
            temp.right = right;
        } else node.right = right;

    }


    public void flatten_2(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new LinkedList<>();
        flattenAdd(root, list);
        TreeNode curr = list.remove(0);
        curr.left = null;
        while (!list.isEmpty()) {
            curr.right = list.remove(0);
            curr.left = null;
            curr = curr.right;
        }
    }

    private void flattenAdd(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        flattenAdd(root.left, list);
        flattenAdd(root.right, list);
    }


    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        node2.left = node3;
        node2.right = node4;
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        node5.right = node6;
        TreeNode node1 = new TreeNode(1);
        node1.right = node5;
        node1.left = node2;
        new FlattenBinaryTreetoLinkedList_114().flatten(node1);
        System.out.println("");
    }
}
