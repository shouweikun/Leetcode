package quiz201_250;

import Context.java.ListNode;

/**
 * Created by john_liu on 2018/12/14.
 */
public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
       ListNode re = head;
       while(re.next!=null) re= re.next;
       reverseList_R(head);
       return re;
    }

    public ListNode reverseList_R(ListNode head) {
        if(head == null) return null;
        if(head.next == null) {
            return  head;
        }else {
            ListNode re =  reverseList_R(head.next);
            re.next = head;
            head.next = null;
            return head;
        }
    }
    public ListNode reverseList2(ListNode head){
        if(head == null) return null;
        ListNode curr = head.next;
        ListNode last = head;
        head.next = null;
        ListNode temp;
        if(curr ==null) return last;
        while(curr != null){
            temp = curr.next;
            curr.next = last;
            if(temp == null) break;
            last =curr;
            curr = temp;

        }

        return curr;
    }



}
