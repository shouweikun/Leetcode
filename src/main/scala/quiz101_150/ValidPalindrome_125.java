package quiz101_150;

/**
 * Created by john_liu on 2019/4/9.
 */
public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        while (rightIndex >= leftIndex) {
            if (rightIndex >= leftIndex && !isVaild(s.charAt(rightIndex))) rightIndex--;
            if (rightIndex >= leftIndex && !isVaild(s.charAt(leftIndex))) leftIndex++;
            if (s.charAt(leftIndex) != s.charAt(rightIndex)) return false;
            rightIndex--;
            leftIndex++;
        }
        return true;
    }

    private boolean isVaild(char c) {
        return (c >= 0 && c <= 9) || (c - 'a' >= 0 && c - 'z' <= 0);
    }
}
