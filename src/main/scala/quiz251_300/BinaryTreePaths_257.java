package quiz251_300;

import Context.java.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2018/11/26.
 */
public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        List<String> c = new LinkedList<>();
        if (isLeaf(root)){
            c.add("" + root.val);
            return c;
        }
        if (root.left != null) addList(root.left, "" + root.val, c);
        if (root.right != null) addList(root.right, "" + root.val, c);
        return c;
    }

    private void addList(TreeNode node, String acc, List<String> c) {
        if (isLeaf(node)) c.add(acc + "->" + node.val);
        else {
            if (node.right != null) addList(node.right, acc + "->" + node.val, c);
            if (node.left != null) addList(node.left, acc + "->" + node.val, c);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && (node.left == null && node.right == null);
    }
}
