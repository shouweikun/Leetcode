package quiz201_250;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by john_liu on 2019/4/20.
 *
 * @note 本题的思考
 * 使用栈来保证最大值的比较
 * 使用队列来保证最大值的获取
 * 通过双端队列来完成这一操作
 * 维护一个滑动窗口
 */
public class SlidingWindowMaximum_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        int[] re = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.pollLast();
            deque.addLast(i);
            if (i - k == deque.peekFirst()) deque.pollFirst();
            if (i - k + 1 >= 0) re[index++] = nums[deque.peekFirst()];
        }
        return re;
    }
}
