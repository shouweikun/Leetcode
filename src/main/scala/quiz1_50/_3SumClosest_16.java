package quiz1_50;

import java.util.Arrays;

/**
 * Created by john_liu on 2018/8/24.
 */
public class _3SumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int size = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int re = Integer.MIN_VALUE;
        for (i = 0; i <= size - 3; i++) {
            int j = i + 1;
            int k = size - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = sum - target;
                if (diff == 0) return target;
                if (diff > 0) k -= 1;
                else j += 1;
                if (Math.abs(diff) < minDiff) {
                    minDiff = Math.abs(diff);
                    re = sum;
                }
            }
        }
        return re;
    }
}
