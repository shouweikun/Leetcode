package quiz301_350;

/**
 * Created by john_liu on 2018/12/22.
 */
public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = -1;
//        int min = -1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                dp[i] = -1;
                if (coins[j] > i) {

                    break;
                }
                if (coins[j] == i) {
                    dp[i] = 1;
                    break;
                }
                if (dp[i - coins[j]] != -1) {
                   if(dp[i]==-1)dp[i] =dp[i - coins[j]]+1;else  dp[i] = Math.min(dp[i - coins[j]]+1,dp[i]);
                }
            }
        }

        return dp[amount];
    }
}
