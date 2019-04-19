package quiz701_750;

/**
 * Created by john_liu on 2019/4/15.
 */
public class SubarrayProductLessThanK_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return backTracking(nums, 0, 1, k, 1);
    }

    private int backTracking(int nums[], int start, int sum, int k, int lastSum) {
        if (sum >= k) return 0;
        int count = sum == lastSum ? 0 : 1;
        if (start >= nums.length) return count;
        return count + backTracking(nums, start + 1, sum, k, sum) + backTracking(nums, start + 1, sum * nums[start], k, sum);
    }
}
