package quiz401_450;

import java.util.*;

/**
 * Created by john_liu on 2019/4/11.
 */
public class N_aryTreeLevelOrderTraversal_429 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> res = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                temp.add(curr.val);
                ListIterator<Node> iter = curr.children.listIterator();
                while (iter.hasNext()) {
                    queue.add(iter.next());
                }
            }
            res.add(temp);
        }

        return res;
    }
}
