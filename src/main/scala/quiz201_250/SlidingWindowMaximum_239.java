package quiz201_250;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by john_liu on 2019/4/20.
 */
public class SlidingWindowMaximum_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();
        int length = nums.length - k + 1;
        int[] re = new int[length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty()) deque.add(nums[i]);
            else {
                while (!deque.isEmpty() && deque.peekLast() <= nums[i]) {
                    deque.pollLast();
                }
                deque.add(nums[i]);
            }
            if (deque.peekFirst() == i - k) deque.pollFirst();
            re[index++] = deque.peekFirst();
        }

        return re;
    }
}
