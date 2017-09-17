package TestOne.fifty_to_hundred;


public class FiftyFive {

    public static boolean canJump(int[] nums) {   // DP
        if (nums == null || nums.length == 0)
            return false;
        int maxIndex = 0;               // max index that can jump to
        for (int i = 0; i <= maxIndex && i < nums.length; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return maxIndex >= nums.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1, 0, 4, 2}));
        System.out.println(canJump(new int[]{2, 0, 4, 2}));
        System.out.println(canJump(new int[]{2, 0, 1, 0, 0}));
    }
}

