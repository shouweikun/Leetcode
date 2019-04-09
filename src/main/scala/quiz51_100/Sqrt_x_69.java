package quiz51_100;

/**
 * Created by john_liu on 2019/4/9.
 */
public class Sqrt_x_69 {
    public int mySqrt(int x) {
        long low = 0;
        long high = x / 2 + 1;
        while (low <= high) {
            long mid = (low + high) / 2;
            long square = mid * mid;
            if (square == x) return (int)mid;
            if (square > x) high = mid - 1;
            else low = mid + 1;
        }
        return (int)high;
    }

    public static void main(String[] args) {
        new Sqrt_x_69().mySqrt(8);
    }
}
