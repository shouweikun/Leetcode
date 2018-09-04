package quiz1_50;

import Context.java.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * Created by john_liu on 2018/8/28.
 */
public class ReverseNodesinKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode iter = head;
        Stack<ListNode> kStack = new Stack<>();
        for(int i =0;i<k;i++){
            if(iter ==null) return head;
            kStack.push(iter);
            iter = iter.next;
        }
        ListNode re = kStack.peek();
        while(kStack.size()>1){
            ListNode curr = kStack.pop();
            curr.next =  kStack.peek();
        }
        ListNode next = reverseKGroup(iter,k);
          head.next = next;
          return re;
    }
}
