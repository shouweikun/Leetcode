package quiz101_150;

import Context.java.ListNode;
import Context.java.TreeNode;

/**
 * Created by john_liu on 2018/11/27.
 */
public class ConvertSortedListtoBinarySearchTree_109 {
    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int size = -1;
        node = head;
        ListNode r = head;
        while (r != null) {
            r = r.next;
            size++;
        }

        return inOrderBuild(0, size);
    }

    private TreeNode inOrderBuild(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode left = inOrderBuild(start, mid-1);
        TreeNode n = new TreeNode(node.val);
        node = node.next;
        TreeNode right = inOrderBuild(mid + 1, end);
        n.left = left;
        n.right = right;
        return n;
    }
}
