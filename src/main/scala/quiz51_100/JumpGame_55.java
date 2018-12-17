package quiz51_100;

/**
 * Created by john_liu on 2018/12/13.
 */
public class JumpGame_55 {

    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= nums.length - 1) dp[i] = 1;
            else {
              for(int j =1;j<=nums[i];j++){
                  if(dp[j+i] ==1) {
                      dp[i] =1;break;
                  }
                  }
            }


        }
        return (dp[0] == 1);
    }

    public static void main(String[] args) {
        int a[]= {3,2,1,0,4};
        new JumpGame_55().canJump(a);
    }
}
