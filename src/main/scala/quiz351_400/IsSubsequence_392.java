package quiz351_400;

/**
 * Created by john_liu on 2019/4/11.
 */
public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        int sPoint = 0;
        int tPoint = 0;
        for (; tPoint < t.length(); tPoint++) {
            if (sPoint >= s.length()) return true;
            if (t.charAt(tPoint) == s.charAt(sPoint)) {
                sPoint++;

                "".equalsIgnoreCase()
            }
        }
        return false;
    }
}
