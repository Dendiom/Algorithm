package LeetCode.hundred_to_two;

public class NinetyEight {

    private static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxWithPre = nums[0];  // max value with pre house robbed
        int maxNoPre = 0;          // nax value with pre house not robbed
        for (int i = 1; i < nums.length; i++) {
            int count = maxNoPre + nums[i];
            maxNoPre = maxWithPre > maxNoPre ? maxWithPre : maxNoPre;
            maxWithPre = count;
        }
        return Math.max(maxWithPre, maxNoPre);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,3,4,2}));
    }
}
