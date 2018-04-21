package LeetCode.two_hundred_to_three;

import java.util.LinkedList;
import java.util.List;

public class Nine {

    /**
     * My approach, use a list to contain elements.
     */
    private static int minSubArrayLen(int s, int[] nums) {
        int ans = 0, sum = 0;
        List<Integer> temp = new LinkedList<>();

        for (int num : nums) {
            sum += num;
            temp.add(num);

            while (sum >= s && temp.size() > 0) {
                if (ans == 0 || ans > temp.size()) {
                    ans = temp.size();
                }

                int remove = temp.get(0);
                sum -= remove;
                temp.remove(0);
            }
        }

        return ans;
    }

    /**
     * Better way.
     */
    private int minSubArrayLenTwo(int s, int[] nums) {
        int ans = 0, sum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = ans == 0 ? i - left + 1 : Math.min(ans, i - left + 1);
                sum -= nums[left++];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
    }
}
