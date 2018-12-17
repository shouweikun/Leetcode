package quiz201_250;

import Context.java.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2018/12/16.
 */
public class LowestCommonAncestorofaBinaryTree_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pPath = new LinkedList<>();
        LinkedList<TreeNode> qPath = new LinkedList<>();
        LinkedList<TreeNode> temp;
        buildPath(p, root, pPath);
        buildPath(q, root, qPath);
        int pLength = pPath.size();
        int qLength = qPath.size();
        int diff = pLength - qLength;
        int abDiff = Math.abs(diff);
        if (diff < 0) {
            temp = pPath;
            pPath = qPath;
            qPath = temp;
        }
        for (int i = 1; i <= abDiff; i++) {
            pPath.poll();
        }
        while (!pPath.isEmpty()) {
            p = pPath.poll();
            q = qPath.poll();
            if (q == p) return p;
        }
        return root;
    }

    private boolean buildPath(TreeNode target, TreeNode root, List<TreeNode> acc) {
        if (root == null) return false;
        boolean re = root == target;
        if (re) {
            acc.add(target);
            return re;
        } else {
            if (buildPath(target, root.left, acc) || buildPath(target, root.right, acc)) {
                acc.add(target);
                return true;
            } else return false;
        }

    }
}
