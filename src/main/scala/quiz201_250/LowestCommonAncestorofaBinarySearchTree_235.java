package quiz201_250;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2019/4/13.
 */
public class LowestCommonAncestorofaBinarySearchTree_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while (root != null) {
            if(q.val<root.val)root = root.left;
            else if(p.val>root.val)root = root.right;
            else return root;
        }

        return null;
    }

}
