package TestOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Fifteen {

    /**
     * give a sorted array and a target num,find all the possible combination whose sum equals target.
     *
     * @param nums   array
     * @param target sum
     * @return ans
     */
    public static List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                ans.add(Arrays.asList(nums[i], nums[j]));
                i++;
                j--;
            } else if (nums[i] + nums[j] > target) {
                do {
                    j--;
                } while (nums[j] == nums[j - 1]);
            } else if (nums[i] + nums[j] < target) {
                do {
                    i++;
                } while (nums[i] == nums[i + 1]);
            }
        }
        return ans;

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{-3, -3, -1, 0, 1, 2, 3, 3, 5}, 2));
    }
}
