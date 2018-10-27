package LeetCode.three_hundred_to_four;

import java.util.Arrays;

public class TwentyTwo {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }

        return  dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2,4,5}, 18));
        System.out.println(coinChange(new int[]{2,4,5}, 1));
        System.out.println(coinChange(new int[]{2,4,5}, 9));
    }
}
