package quiz151_200;

/**
 * Created by john_liu on 2018/12/12.
 */
public class HouseRobber_198 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i+2] = Math.max(dp[i]+nums[i],dp[i+1]);
        }
        return dp[nums.length+1];
    }


}
