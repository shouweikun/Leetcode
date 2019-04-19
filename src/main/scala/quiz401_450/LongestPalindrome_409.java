package quiz401_450;

/**
 * Created by john_liu on 2019/4/10.
 */
public class LongestPalindrome_409 {
    public int longestPalindrome(String s) {
        if (s.length() <= 1) return s.length();
        char[] chars = new char[26];
        int re = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            chars[i] += 1;
            if (chars[i] == 2) {
                re += 2;
                chars[i] = 0;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) return re + 1;
        }
        return re;
    }

    public static void main(String[] args) {
        new LongestPalindrome_409().longestPalindrome("abccccdd");
    }
}
