package quiz51_100;

/**
 * Created by john_liu on 2018/12/22.
 */
public class UniqueBinarySearchTrees_96 {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }
}
