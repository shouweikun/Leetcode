package quiz101_150;

import Context.java.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2018/11/24.
 */
public class PathSum2_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> acc = new LinkedList<>();
        judgeThenaddPathSum(root, sum, new LinkedList<>(), acc);
        return acc;
    }

    public void judgeThenaddPathSum(TreeNode node, int sum, List<Integer> path, List<List<Integer>> acc) {
        if (node == null) return;
        LinkedList<Integer> newPath = new LinkedList<Integer>(path);
        newPath.add(node.val);
        if (node.val == sum && node.left == null && node.right == null) acc.add(newPath);
        else {
            int nextSum = sum - node.val;
            if (node.left != null) judgeThenaddPathSum(node.left, nextSum, newPath, acc);
            if (node.right != null) judgeThenaddPathSum(node.right, nextSum, newPath, acc);
        }
        return;
    }
}
