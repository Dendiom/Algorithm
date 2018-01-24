package LeetCode.two_hundred_to_three;

public class Thirteen {

    /**
     * Answer = max(RobOne(0, length - 2), RobOne(1, length - 1))
     */
    private static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int maxOne = robOne(nums, 0, length - 2);
        int maxTwo = robOne(nums, 1, length - 1);
        return Math.max(maxOne, maxTwo);
    }

    /**
     * LeetCode one hundred and ninety eight
     */
    private static int robOne(int[] nums, int start, int end) {
        int maxWithPre = nums[start];  // max value with pre house robbed
        int maxNoPre = 0;          // max value with pre house not robbed
        for (int i = start + 1; i < end + 1; i++) {
            int count = maxNoPre + nums[i];
            maxNoPre = maxWithPre > maxNoPre ? maxWithPre : maxNoPre;
            maxWithPre = count;
        }
        return Math.max(maxWithPre, maxNoPre);
    }


    public static void main(String[] args) {
        System.out.println(rob(new int[]{3}));
        System.out.println(rob(new int[]{1, 3}));
        System.out.println(rob(new int[]{1, 6, 3, 4}));
        System.out.println(rob(new int[]{6, 1, 3, 9}));
    }
}
