package LeetCode.two_hundred_to_three;


public class SixtyFour {

    /**
     * Solution from leetcode.
     * ugly[n] = min(2 * ugly[i], 3 * ugly[j], 5 * ugly[k]). If 2 * ugly[i] is the minimum,
     * ugly[n + 1] = min(2 * ugly[i + 1], 3 * ugly[j], 5 * ugly[k]).
     */
    private static int nthUglyNumber(int n) {
        if (n == 0) {
            return 1;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(2 * dp[index2], Math.min(3 * dp[index3], 5 * dp[index5]));
            System.out.println(dp[i]);
            if (dp[i] == 2 * dp[index2]) {
                index2++;
            }

            if (dp[i] == 3 * dp[index3]) {
                index3++;
            }

            if (dp[i] == 5 * dp[index5]) {
                index5++;
            }
        }

        return dp[n - 1];
    }


    public static void main(String[] args) {
        //System.out.println(nthUglyNumber(6));
        //System.out.println(nthUglyNumber(7));
        System.out.println(nthUglyNumber(8));
    }
}
