package TestOne.fifty_to_hundred;


public class SixtyTwo {

    public static int uniquePathsNotGood(int m, int n) {    // this method isn't very good, number may be too big
        if (m == 1 || n == 1)
            return 1;
        int use = Math.min(m, n);
        return (int) (helperMethod(m + n - 2, use - 1) / helperMethod(use - 1, use - 1));
    }

    private static long helperMethod(int start, int num) {
        long ans = start;
        long count = 1;
        while (count < num) {
            ans = ans * (start - count);
            count++;
        }
        // System.out.println(ans);
        return ans;
    }


    public static int uniquePaths(int m, int n) {   // using dp is better
        if (m == 1 || n == 1)
            return 1;
        int[][] paths = new int[m][n];

        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1;j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsNotGood(10, 10));
        System.out.println(uniquePaths(10, 10));
    }
}
