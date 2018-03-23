package LeetCode.two_hundred_to_three;

import java.util.ArrayList;
import java.util.List;

public class TwentyNine {

    /**
     * Boyer-Moore majority vote algorithm
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        int countOne = 0, countTwo = 0;
        int majorityOne = -1, majorityTwo = -1;
        for (int i : nums) {
            if (i == majorityOne) {
                countOne++;
            } else if (i == majorityTwo) {
                countTwo++;
            } else {
                if (countOne == 0) {
                    majorityOne = i;
                    countOne++;
                } else if (countTwo == 0) {
                    majorityTwo = i;
                    countTwo++;
                } else {
                    countOne--;
                    countTwo--;
                }
            }
        }

        int checkOne = 0, checkTwo = 0;
        for (int i: nums) {
            if (i == majorityOne) {
                checkOne++;
            }

            if (i == majorityTwo) {
                checkTwo++;
            }
        }

        if (checkOne > nums.length / 3) {
            ans.add(majorityOne);
        }

        if (checkTwo > nums.length / 3) {
            ans.add(majorityTwo);
        }

        return ans;
    }
}
