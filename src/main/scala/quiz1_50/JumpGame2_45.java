package quiz1_50;

/**
 * Created by john_liu on 2019/4/25.
 */
public class JumpGame2_45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;
        int[] dp = new int[nums.length];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (max >= nums.length - 1) return dp[nums.length - 1];
            if (i > max) return -1;
            max = Math.max(i + nums[i], max);
            int upper = Math.min(max, nums.length - 1);
            for (int j = upper; j >i; j--) {
                if(dp[j]!=0)break;
                dp[j] = dp[i] + 1;
            }

        }
        return -1;
    }
}
