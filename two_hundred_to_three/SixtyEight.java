package LeetCode.two_hundred_to_three;

public class SixtyEight {

    // avoid int overflow
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += i - nums[i];
        }

        return ans + nums.length;
    }
}
