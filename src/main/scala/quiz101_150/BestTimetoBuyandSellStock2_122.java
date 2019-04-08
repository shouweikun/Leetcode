package quiz101_150;

/**
 * Created by john_liu on 2019/4/8.
 */
public class BestTimetoBuyandSellStock2_122 {

    public int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) count += prices[i] - prices[i - 1];
        }
        return count;
    }
}
