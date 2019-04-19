package quiz101_150;

import java.util.Arrays;

/**
 * Created by john_liu on 2019/4/19.
 */
public class PalindromePartitioning2_132 {

    public int minCut(String s) {
        if (s == null || s.length() <= 1) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] dp2 = new int[s.length()];
        Arrays.fill(dp2, Integer.MAX_VALUE);
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (j == i) dp[i][j] = true;
                else if (j == i + 1) dp[i][j] = s.charAt(i) == s.charAt(j);
                else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
            }
        }
        dp2[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (dp[0][i]) {
                dp2[i] = 1;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j + 1][i]) dp2[i] = Math.min(dp2[i], dp2[j] + 1);
            }
        }
        return dp2[dp2.length - 1]-1;
    }


}
