package LeetCode.hundred_to_two;

public class FiftyTwo {


    /**
     * Dp with two arrays to save max and min value.
     */
    private static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int[] dpMin = new int[length];
        int[] dpMax = new int[length];
        int max = dpMax[0] = dpMin[0] = nums[0];

        for (int i = 1; i < length; i++) {
            dpMin[i] = Math.min(nums[i], Math.min(dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]));
            dpMax[i] = Math.max(nums[i], Math.max(dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]));
            max = Math.max(max, dpMax[i]);
        }

        return max;
    }

    /**
     * Dp without array.
     */
    private static int maxProductWithoutArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int minLocal, maxLocal, minLocalPre, maxLocalPre, max;
        max = minLocalPre = maxLocalPre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minLocal = Math.min(nums[i], Math.min(minLocalPre * nums[i], maxLocalPre * nums[i]));
            maxLocal = Math.max(nums[i], Math.max(minLocalPre * nums[i], minLocalPre * nums[i]));
            minLocalPre = minLocal;
            maxLocalPre = maxLocal;
            max = Math.max(max, maxLocal);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{1,3,2,4}));
        System.out.println(maxProductWithoutArray(new int[]{1,-3,2,-4}));
        System.out.println(maxProductWithoutArray(new int[]{-1,0,2,-4}));
    }
}
