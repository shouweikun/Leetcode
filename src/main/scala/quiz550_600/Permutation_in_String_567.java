package quiz550_600;

/**
 * Created by john_liu on 2019/4/7.
 */
public class Permutation_in_String_567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        buildArray(s1, 0, s1.length(), count1);
        buildArray(s2, 0, s1.length(), count2);
        if (compare(count1, count2)) return true;
        for (int i = s1.length(); i < s2.length(); i++) {
            int removeIndex = s2.charAt(i - s1.length()) - 'a';
            int addIndex = s2.charAt(i) - 'a';
            count2[removeIndex] -= 1;
            count2[addIndex] += 1;
            if (compare(count1, count2)) return true;
        }
        return false;
    }

    private void buildArray(String s, int from, int to, int[] arr) {
        for (; from < to; from++) {
            int index = s.charAt(from) - 'a';
            arr[index] = arr[index] + 1;
        }
    }

    private boolean compare(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
