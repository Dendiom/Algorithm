package LeetCode.three_hundred_to_four;

public class Nine {
    /**
     * DP.
     * Use a state machine to represent three status:
     * s0: wait to buy/ s1: wait to sell/ s2: sell out
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int s0 = 0, s1 = -prices[0], s2 = 0;
        int s0Dup = 0, s1Dup = 0, s2Dup = 0;
        for (int i = 0; i < prices.length; i++) {
            s0Dup = s0;
            s1Dup = s1;
            s2Dup = s2;
            s0 = Math.max(s2Dup, s0Dup);
            s1 = Math.max(s1Dup, s0Dup - prices[i]);
            s2 = s1Dup + prices[i];
        }

        return Math.max(s0, s2);
    }
}
