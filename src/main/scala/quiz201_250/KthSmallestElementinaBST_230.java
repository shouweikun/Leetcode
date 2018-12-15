package quiz201_250;

import Context.java.TreeNode;

/**
 * Created by john_liu on 2018/12/14.
 */
public class KthSmallestElementinaBST_230 {

    public int kthSmallest(TreeNode root, int k) {
        int[] context = {0,0};
        find(root,k,context);
        return context[1];
    }

    public void find(TreeNode node,int k,int[] context){
        if(node == null) return ;
        if(context[0] !=k){
            find(node,k,context);
        }

        if(context[0] !=k){
            context[0] = context[0]+1;
            context[1] =node.val;
        }

        if(context[0]!=k){
            find(node.right,k,context);
        }

    }

}
