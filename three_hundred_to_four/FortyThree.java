package LeetCode.three_hundred_to_four;

public class FortyThree {
    /**
     * Dynamic Programming
     * f(n) = Max({1，n - 1}, {2, n - 2}, {3, n - 3}...)
     * {m, n -m} = Max(m, f(m)) * Max(n - m, f(n - m))
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            int max = 1;
            for (int j = 1; j <= i/2; j++) {
                int left = Math.max(dp[j], j);
                int right = Math.max(dp[i - j], i - j);
                max = Math.max(max, left * right);
            }

            dp[i] = max;
        }

        return dp[n];
    }
}
