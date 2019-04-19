package quiz101_150;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2019/4/19.
 */
public class PalindromePartitioning_131 {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return Collections.emptyList();
        List<List<String>> re = new LinkedList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (j == i) dp[i][j] = true;
                else if (j == i + 1) dp[i][j] = s.charAt(i) == s.charAt(j);
                else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
            }
        }
        backTracking(dp, s, re, new LinkedList<>(), 0);
        return re;
    }

    private void backTracking(boolean[][] dp, String s, List<List<String>> res, LinkedList<String> tmp, int start) {
        if (start == s.length()) {
            res.add(new LinkedList<>(tmp));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (!dp[start][i]) continue;
                tmp.add(s.substring(start, i + 1));
                backTracking(dp, s, res, tmp, i+1);
                tmp.removeLast();
            }
        }

    }

    public static void main(String[] args) {
        new PalindromePartitioning_131().partition("aab");
    }
}
