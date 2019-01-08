package quiz251_300;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2018/12/18.
 */
public class PerfectSquares_279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        List<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                list.add(i);
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j : list) {
                    min = Math.min(dp[i-j]+1,min);
                }
                dp[i] = min;
            }
        }
        return  dp[n];
    }
}
