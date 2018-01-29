package LeetCode.two_hundred_to_three;

public class TwentyOne {

    /**
     * use a int[m][n] dp to record max square at this point(this point is the last one in the square).
     * Step 1: init first raw & col of dp[m][n].
     * Step 2: from dp[1][1] to dp[m - 1][ n -1].for each point, check dp[i - 1][j - 1],
     *         dp[i - 1][j], dp[i][j - 1].
     *         if (matrix[i][j] == '0')
     *              dp[i][j] = 0
     *         else
     *              if (exits 0)
     *                  dp[i][j] = 1
     *              else
     *                  if (one == two == three)
     *                      dp[i][j] = (sqrt(one) + 1)) ^ 2
     *                  else
     *                      dp[i][j] = (sqrt(min(one, two three)) + 1)^2
     *
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {  // first col
            if (matrix[i][0] == '1') {
                max = 1;
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }

        for (int i = 0; i < n; i++) { // first raw
            if (matrix[0][i] == '1') {
                max = 1;
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1;i < m; i++) {
            for(int j = 1;j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }

                if (dp[i - 1][j - 1] == 0 || dp[i - 1][j] == 0 || dp[i][j - 1] == 0) {
                    dp[i][j] = 1;
                } else {
                    if (dp[i - 1][j - 1] == dp[i - 1][j] && dp[i - 1][j - 1] == dp[i][j - 1]
                            && dp[i - 1][j] == dp[i][j - 1]) {  // all the same
                        dp[i][j] = (int)Math.pow(Math.sqrt(dp[i - 1][j]) + 1, 2);
                    } else {
                        int temp = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                        dp[i][j] = (int)Math.pow(Math.sqrt(temp) + 1, 2);
                    }

                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {

    }
}
