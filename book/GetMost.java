package LeetCode.book;

/**
 *
 * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。
 * 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。
 */
public class GetMost {

    /**
     * 典型的动态规划问题 dp[m][n] = Max(dp[m - 1][n], dp[m][n - 1]) + values[m][n]
     */
    public int getMost(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }

        int m = values.length;
        int n = values[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = values[0][0];
        for (int i = 1; i < m; i++) { // 第一列
            dp[i][0] = values[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < n; i++) { // 第一行
            dp[0][i] = values[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + values[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
