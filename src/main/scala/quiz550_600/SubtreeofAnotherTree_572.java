package quiz550_600;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2019/4/15.
 */
public class SubtreeofAnotherTree_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        return isSubTreeInternal(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }


    public boolean isSubTreeInternal(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (s == null || t == null) return false;
        if (t.val == s.val) return isSubTreeInternal(s.right, t.right) && isSubTreeInternal(s.left, t.left);
        else return false;
    }
}
