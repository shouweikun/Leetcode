package quiz1_50;

/**
 * Created by john_liu on 2019/4/10.
 */
public class dfd_5 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int re = 1;
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            int even = s.charAt(i) == s.charAt(i - 1) ? 2 : 1;
            int odd = (i - 1 - dp[i - 1] >= 0) && s.charAt(i - 1 - dp[i - 1]) == s.charAt(i) ? dp[i - 1] + 2 : 1;
            dp[i] = Math.max(even, odd);
            if (re < dp[i]) {
                re = dp[i];
                index = i;
            }
        }
        return s.substring(index - dp[index]+1, index + 1);
    }

    public static void main(String[] args) {
        new dfd_5().longestPalindrome("ccc");

    }
}
