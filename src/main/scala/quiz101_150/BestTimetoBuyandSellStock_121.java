package quiz101_150;

/**
 * Created by john_liu on 2019/4/8.
 */
public class BestTimetoBuyandSellStock_121 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int max = 0;
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell[i] = buy[i - 1] + prices[i];
            buy[i] = Math.max(-prices[i], buy[i-1]);
        }

        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, sell[i]);
        }

        return max;
    }
}
