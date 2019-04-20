package quiz201_250;

/**
 * Created by john_liu on 2019/4/15.
 */
public class NumberofDigitOne_233 {
    public int countDigitOne(int n) {
        int org = n;
        int length = 0;
        for (int i = n; i >= 1; i /= 10) length++;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = n % 10;
            n = n / 10;
        }
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (i == 0) {
                return ++count;
            }
            int base = (int) Math.pow(10, i);
            count += res[i] * base / 10 - (i - 1) * Math.pow(9, i - 1) + org % base;
        }
        return count;

    }

    public static void main(String[] args) {
        new NumberofDigitOne_233().countDigitOne(13);

    }
}
