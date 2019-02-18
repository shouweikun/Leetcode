package quiz1_50;

/**
 * Created by john_liu on 2018/12/17.
 */
public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        if(s == null)return null;
        if(s.length() == 0)return "";
        int[] dp = new int[s.length()];
        char[]chars = s.toCharArray();
        int max = 0;
        int maxIndex = 0;
        dp[0] = 1;
        for(int i = 1;i<s.length();i++){
                int prev = i-1-dp[i-1];
                if(prev>=0&&chars[prev] ==chars[i])dp[i] = dp[i-1]+2;
                else if (chars[i-1]==chars[i])dp[i] =2; else dp[i] = 1;
            if(max<dp[i]){
                max = dp[i];
                maxIndex = i;
            }
        }
        return s.substring(maxIndex-max,maxIndex);
    }
}
