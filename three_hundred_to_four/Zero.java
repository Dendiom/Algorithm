package LeetCode.three_hundred_to_four;

import java.util.Arrays;

public class Zero {

    // dp
    public static int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1, 3, 5, 2, 6, 2}));
        System.out.println(lengthOfLIS(new int[]{1, 3, 2, 1}));
        System.out.println(lengthOfLIS(new int[]{9, 5, 3, 2, 6, 2}));
    }
}
