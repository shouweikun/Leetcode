package quiz500_550;

import Context.java.TreeNode;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2018/12/18.
 */
public class FindLargestValueinEachTreeRow_515 {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        Deque<TreeNode> deque = new LinkedList<>();
        LinkedList<Integer> re = new LinkedList<>();
        deque.offer(root);
        int size, max;
        TreeNode temp;
        while (!deque.isEmpty()) {
            size = deque.size();
            max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                temp = deque.poll();
                max = Math.max(temp.val, max);
                if (temp.left != null) deque.offer(temp.left);
                if (temp.right != null) deque.offer(temp.right);
            }
            re.add(max);
            max = Integer.MIN_VALUE;
        }

        return re;
    }
}
