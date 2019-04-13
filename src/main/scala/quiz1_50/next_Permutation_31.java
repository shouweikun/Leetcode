package quiz1_50;

import Context.java.ListNode;
import scala.Int;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2019/4/2.
 */
public class next_Permutation_31 {

    public List<Integer> nextPermutation(int[] nums) {
        int index = -1;
        List<Integer> re = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                index = i - 1;
            }
        }
        if (index == -1) {
            Arrays.sort(nums);
            re = null;
            return re;
        }
        int matchIndex = -1;
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                matchIndex = i;
                break;
            }
        }
        for (int i = 0; i < index; i++) {
            re.add(nums[i]);
        }
        re.add(nums[matchIndex]);
        for (int i = index; i < nums.length; i++) {
            if (i == matchIndex) break;
            re.add(nums[i]);
        }
        return re;
    }

    public ListNode mergeKList(ListNode[] nodes) {
        if (nodes.length == 0) return null;
        if (nodes.length == 1) return nodes[0];
        ListNode head = null;
        ListNode iter = null;
        do {
            int index = 0;
            for (int i = 1; i < nodes.length; i++) {
                if (nodes[i] != null) {
                    if (nodes[index] != null) {
                        if (nodes[i].val < nodes[index].val) index = i;
                    } else index = i;
                }
            }
            iter.next = nodes[index];
            iter = iter.next;
            if (nodes[index] != null) nodes[index] = nodes[index] = nodes[index].next;
            if (head == null) head = iter;

        } while (iter != null);
        return head;
    }
}
