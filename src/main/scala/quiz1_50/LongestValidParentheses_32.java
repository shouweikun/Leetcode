package quiz1_50;

/**
 * Created by john_liu on 2018/12/17.
 */
public class LongestValidParentheses_32 {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;

        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        int re = 0;
        int pre = 0;
        for (int i = 1; i < s.length(); i++) {
            if (chars[i] == ')') {
                pre = i - 1 - dp[i - 1];
                if (pre >= 0 && chars[pre] == '(')
                    dp[i] = dp[i - 1] + 2 + ((pre > 0 && chars[pre - 1] == ')') ? dp[pre - 1] : 0);
            }

            re = Math.max(dp[i],re);
        }
        return re;
    }

    public static void main(String[] args) {
        new LongestValidParentheses_32().longestValidParentheses("(()");
    }
}
