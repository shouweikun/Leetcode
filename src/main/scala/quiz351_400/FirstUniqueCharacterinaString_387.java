package quiz351_400;

/**
 * Created by john_liu on 2019/4/14.
 */
public class FirstUniqueCharacterinaString_387 {

    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            letters[index]++;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (letters[index] == 1) return i;
        }
        return -1;
    }
}
