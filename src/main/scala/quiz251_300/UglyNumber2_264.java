package quiz251_300;

/**
 * Created by john_liu on 2019/4/13.
 */
public class UglyNumber2_264 {
    public int nthUglyNumber(int n) {
        int point2 = 0, point3 = 0, point5 = 0;
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        for (int i = 1; i < n; i++) {
            int a = uglyNumbers[point2] * 2;
            int b = uglyNumbers[point3] * 3;
            int c = uglyNumbers[point5] * 5;
            uglyNumbers[i] = getMin(a, b, c);
            if (uglyNumbers[i] == a) point2++;
            if (uglyNumbers[i] == b) point3++;
            if (uglyNumbers[i] == c) point5++;
        }
        return uglyNumbers[n - 1];
    }

    private int getMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
