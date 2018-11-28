package LeetCode.book;

/**
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
 * 例：n = 10, return 36 (10 = 3 + 3 + 4)
 */
public class IntegerBreak {

    /**
     * 动态规划
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int temp = Math.max(j * (i - j), dp[j] * (i - j));
                dp[i] = Math.max(dp[i], temp);
            }
        }

        return dp[n];
    }
}
