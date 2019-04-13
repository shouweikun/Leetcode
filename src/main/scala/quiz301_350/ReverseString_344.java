package quiz301_350;

/**
 * Created by john_liu on 2019/4/10.
 */
public class ReverseString_344 {
    public void reverseString(char[] s) {
        int low = 0;
        int high = s.length - 1;
        while (low <= high) {
            swap(s,low,high);
            low++;
            high--;
        }
    }

    private void swap(char[] s, int i, int j) {
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
}


