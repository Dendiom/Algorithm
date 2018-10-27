package LeetCode.two_hundred_to_three;

import java.util.Arrays;

public class SeventyNine {

    // dp
    public int numSquares(int n) {
        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int i = 0; i * i <= n; i++) {
            ans[i * i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                ans[i + j * j] = Math.min(ans[i] + 1, ans[i + j * j]);
            }
        }

        return ans[n];
    }
}
