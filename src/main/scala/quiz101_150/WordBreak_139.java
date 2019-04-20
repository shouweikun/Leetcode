package quiz101_150;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by john_liu on 2019/4/20.
 */
public class WordBreak_139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        boolean[][] dp = new boolean[wordDict.size()][s.length()];
        for (int i = 0; i < wordDict.size() - 1; i++) {
            for (int j = 0; j < s.length(); j++) {

            }
        }
        return true;
    }

    public boolean wordBreak_2(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        Set<String> set = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
