package LeetCode.book;

/**
 * 股票的最大利润.
 * 可以有一次买入和一次卖出，那么买入必须在前。求最大收益。
 */
public class MaxProfit {

    /**
     * 假设在第i天进行卖出，便利一边可得在哪天卖出时收益最大
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return result;
    }
}
