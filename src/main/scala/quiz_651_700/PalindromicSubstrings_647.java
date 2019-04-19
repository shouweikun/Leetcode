package quiz_651_700;

/**
 * Created by john_liu on 2019/4/13.
 */
public class PalindromicSubstrings_647 {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int re = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            for (int j = i; j < s.length(); ++j) {
                if (i == j) dp[i][j] = true;
                else if (i+1 ==  j) dp[i][j] = s.charAt(i) == s.charAt(j);
                else dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                if (dp[i][j]) re++;
            }
        }


        return re;
    }


}
