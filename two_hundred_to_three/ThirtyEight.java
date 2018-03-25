package LeetCode.two_hundred_to_three;

public class ThirtyEight {

    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int productExceptZero = 1;
        int count = 0;
        int[] ans = new int[nums.length];
        for (int i: nums) {
            product *= i;
            if (i == 0) {
                count++;
            } else {
                productExceptZero *= i;
            }
        }

        if (count > 1) {
            return ans;   // all zeros
        }

        for (int i = 0; i <nums.length; i++) {
            if (nums[i] != 0) {
                ans[i] = product / nums[i];
            } else {
                ans[i] = productExceptZero;
            }
        }

        return ans;
    }
}
