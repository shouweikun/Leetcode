package quiz1_50;

/**
 * Created by john_liu on 2018/12/17.
 */
public class LongestValidParentheses_32 {


    public int longestValidParentheses(String s) {
        if (s.length() <= 1) return 0;
        int[] dp = new int[s.length()];
        int re = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int pre = i - dp[i - 1] - 1;
                if (pre >= 0 && s.charAt(pre) == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            re = Math.max(re, dp[i]);
        }
        return re;
    }


    public static void main(String[] args) {
        new LongestValidParentheses_32().longestValidParentheses("(()");
    }
}
