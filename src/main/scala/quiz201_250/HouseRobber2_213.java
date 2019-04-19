package quiz201_250;

/**
 * Created by john_liu on 2018/12/12.
 */
public class HouseRobber2_213 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robLine(nums, 0, nums.length - 2), robLine(nums, 1, nums.length - 1));
    }

    public int robLine(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;
        int curr = 0;
        for (int i = start; i <= end; i++) {
            curr = Math.max(nums[start] + prev2, prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
