package TestOne.fifty_to_hundred;


public class SixtyFour {

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean mFlag = m == 1;
        boolean nFlag = n == 1;
        if (mFlag && nFlag) {
            return grid[0][0];
        }

        if (!nFlag) {
            for (int i = 1; i < n; i++) {
                grid[0][i] += grid[0][i - 1];
            }
            if (mFlag)
                return grid[0][n - 1];
        }

        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        if (nFlag)
            return grid[m - 1][0];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {

    }
}


