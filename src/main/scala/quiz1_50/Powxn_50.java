package quiz1_50;

/**
 * Created by john_liu on 2019/4/13.
 */
public class Powxn_50 {
    public double myPow(double x, int n) {
        double re = 1;
        long N = Math.abs((long)n);
        double base = x;
        while (N > 0) {
            if ((N & 1) == 1) re *= base;
            base *= base;
            N >>= 1;
        }
        return n<0? 1/re:re;
    }
}
