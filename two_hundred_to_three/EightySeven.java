package LeetCode.two_hundred_to_three;

import java.util.Arrays;

public class EightySeven {
    /**
     * O(1) space & O(nlogn) time complexity
     */
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                return pre;
            }

            pre = nums[i];
        }

        return -1;
    }

    /**
     * Able to modify the array.
     */
    public int findDuplicateTwo(int[] nums) {
        int index = 0;
        while (index < nums.length && nums[index] != -1) {
            int temp = nums[index];
            nums[index] = -1;
            index = temp;
        }

        return index;
    }
}
