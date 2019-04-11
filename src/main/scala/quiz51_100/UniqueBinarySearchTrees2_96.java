package quiz51_100;

import Context.java.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2019/4/11.
 */
public class UniqueBinarySearchTrees2_96 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return Collections.EMPTY_LIST;
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> re = new LinkedList<>();
        if (start > end) {
            re.add(null);
            return re;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    re.add(root);
                }
            }
        }

        return re;
    }
}
