package quiz1_50;

import Context.java.ListNode;

/**
 * Created by john_liu on 2018/8/25.
 */
public class Merge2SortedList_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        boolean l1IsNotNull = l1 != null;
        boolean l2IsNotNull = l2 != null;
        if (!l1IsNotNull && !l2IsNotNull) return null;
        if (!l1IsNotNull) return l2;
        if (!l2IsNotNull) return l1;
        ListNode re;
        if(l1.val < l2.val) {
            re =  l1 ;
            l1 = l1.next;
            l1IsNotNull = l1 != null;
        }  else{
            re = l2;
            l2 = l2.next;
            l2IsNotNull = l2 != null;
        }

        ListNode current = re;
        while (l1IsNotNull || l2IsNotNull) {
            if (!l1IsNotNull) {
                current.next = l2;
                break;
            }
            if (!l2IsNotNull) {
                current.next = l1;
                break;
            }
            System.out.println(l1);
            System.out.println(l2);
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
                l1IsNotNull = l1 != null;
            } else {
                current.next = l2;
                l2 = l2.next;
                l2IsNotNull = l2 != null;
            }


            current = current.next;


        }

        return re;
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_r(ListNode l1, ListNode l2){
        if(l1 == null) return  l2;
        if(l2 ==  null) return l1;
        if(l1.val>l2.val){
            l1.next = mergeTwoLists_r(l1.next,l2);
            return l1;
        } else{
            l2.next = mergeTwoLists_r(l1,l2.next);
            return l2;
        }
    }

}
