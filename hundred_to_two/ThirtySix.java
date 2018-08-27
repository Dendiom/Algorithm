package LeetCode.hundred_to_two;

import java.util.HashMap;
import java.util.Map;

public class ThirtySix {

    /**
     * use bit algorithm
     */
    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }

    /**
     * hash map
     */
    public static int single(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum1 = 0, sum2 = 0;
        for (int num: nums) {
            sum1 += num;
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                sum2 += 2 * num;
            }
        }

        return sum1 - sum2;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,2,2,1,4,4,3}));
        System.out.println(single(new int[]{3,3,2,2,1,1,5,6,5}));
    }
}
