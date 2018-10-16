package tips;

import Context.java.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by john_liu on 2018/10/16.
 */
public class BinaryTreeTraversal_Java {

    private List<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> re = new LinkedList<>();
        if (root == null) return re;
        TreeNode curr = null;
        TreeNode last = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.peek();
            boolean rightIsNull = curr.right == null;
            boolean leftIsNull = curr.left == null;

            if (rightIsNull) {
                if (leftIsNull) {
                    stack.pop();
                    re.add(curr.val);
                    last = curr;
                } else if (last == curr.left) {
                    stack.pop();
                    re.add(curr.val);
                    last = curr;
                } else {
                    stack.push(curr.left);
                }
            } else {
                if (leftIsNull) {
                    if (curr.right == last) {
                        stack.pop();
                        re.add(curr.val);
                        last = curr;
                    } else {
                        stack.push(curr.right);
                    }
                } else {
                    if (curr.right == last) {
                        stack.pop();
                        re.add(curr.val);
                        last = curr;
                    } else {
                        stack.push(curr.right);
                        stack.push(curr.left);
                    }
                }
            }
        }
        return re;
    }
}
