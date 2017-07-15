package TestOne.one_to_fifty;

import java.util.*;


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
                do {
                    i++;
                    j--;
                } while (i < j && nums[i] == nums[i - 1] && nums[j] == nums[j + 1]);
                ans.add(Arrays.asList(nums[i], nums[j]));
            } else if (nums[i] + nums[j] > target)
                j--;
            else if (nums[i] + nums[j] < target)
                i++;
        }
        return ans;

    }



    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int start = i + 1;
            int end = nums.length - 1;
            //two sum
            while (start < end) {
                if (nums[start] + nums[end] == 0 - nums[i]) {
                    ans.add(Arrays.asList(nums[start], nums[end], nums[i]));
                    do {
                        start++;
                        end--;
                    } while (start < end && nums[start] == nums[start - 1] && nums[end] == nums[end + 1]);
                } else if (nums[start] + nums[end] > 0 - nums[i]) {
                    end--;
                } else if (nums[start] + nums[end] < 0 - nums[i]) {
                    start++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{-2, -1, 1, 2}, 1));
        System.out.println(twoSum(new int[]{0, 2, 2, 3}, 4));
        // System.out.println(threeSum(new int[]{-2, -1, 1, 2}));
        // System.out.println(threeSum(new int[]{-3, -3, -1, 0, 1, 2, 3, 3, 5}));
        //  System.out.println(threeSum(new int[]{3, -3, -1,5, 0, 1, 2, 7, 3, -5}));
        //  System.out.println(threeSum(new int[]{0,0,0,2,0,-2,2,5}));
        //  System.out.println(twoSum(new int[]{0, 0, 0, 0, 0, 0}, 0));
        // System.out.println(threeSum(new int[]{0,0,0,0,0,0}));
        // System.out.println(twoSum(new int[]{-4,-1, - 1, 0, 1, 2}, 4));
    }
}
