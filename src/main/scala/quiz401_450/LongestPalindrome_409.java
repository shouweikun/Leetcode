package quiz401_450;

/**
 * Created by john_liu on 2019/4/10.
 */
public class LongestPalindrome_409 {
    public int longestPalindrome(String s) {
        if (s.length() <= 1) return s.length();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int re = 1;
        for (int i = 1; i < s.length(); i++) {
            int even = s.charAt(i) == s.charAt(i - 1) ? 2 : 1;
            int odd = (i - 1 - dp[i - 1] >= 0) && s.charAt(i - 1 - dp[i - 1]) == s.charAt(i) ? dp[i - 1] + 2 : 1;
            dp[i] = Math.max(even, odd);
            re = Math.max(re, dp[i]);
        }
        return re;
    }

    public static void main(String[] args) {
        new  LongestPalindrome_409().longestPalindrome("abccccdd");
    }
}
