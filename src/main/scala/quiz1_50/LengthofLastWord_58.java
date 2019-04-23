package quiz1_50;

/**
 * Created by john_liu on 2019/4/23.
 */
public class LengthofLastWord_58 {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int index = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                index = i;
                break;
            }
        }
        if (index == -1) return 0;
        else {
            int start = index;
            for (; start >= 0; start--) {
                if (s.charAt(start) == ' ') {
                    return index - start;
                }
            }
            return 0;
        }

    }
}
