package LeetCode.three_hundred_to_four;

public class ThirtyFour {

    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                return true;
            }

            if (nums[i] > min) {
                max = nums[i];
            } else {
                min = nums[i];
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1, 3, 4, 3, 2}));
        System.out.println(increasingTriplet(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(increasingTriplet(new int[]{7, 8, 5, 6, 7}));
    }
}
