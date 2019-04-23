package quiz51_100;

import java.util.Stack;

/**
 * Created by john_liu on 2019/4/18.
 *
 *
 * @note 栈的使用技巧 用栈来维护当前元素最小高度
 */
public class LargestRectangleinHistogram_84 {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int height = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() & height < heights[stack.peek()]) {
                stack.pop();
            }
            int right = i;
            int left = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, (right - left - 1) * height);
            stack.push(i);
        }
return max;
    }
}
