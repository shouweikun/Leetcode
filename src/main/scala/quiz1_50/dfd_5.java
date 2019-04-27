package quiz1_50;

/**
 * Created by john_liu on 2019/4/10.
 */
public class dfd_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int startIndex = 0;
        int endIndex = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (j == i) dp[i][j] = true;
                else if (j == i + 1) dp[i][j] = s.charAt(i) == s.charAt(j);
                else dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                if (dp[i][j]) {
                    if (j - i > endIndex - startIndex) {
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

    public static void main(String[] args) {
        new dfd_5().longestPalindrome("ccc");

    }
}
