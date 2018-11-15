package LeetCode.three_hundred_to_four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SixtyEight {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List[] dp = new List[nums.length];
        Arrays.sort(nums);
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) { // get dp[i]
            dp[i] = new ArrayList();
            int globalMax = -1; // chose which to append
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (globalMax == -1) {
                        globalMax = j;
                    } else {
                        if (dp[j].size() > dp[globalMax].size()) {
                            globalMax = j;
                        }
                    }
                }
            }

            if (globalMax != -1) {
                List<Integer> temp = dp[globalMax];
                for (int k = 0; k < temp.size(); k++) {
                    dp[i].add(temp.get(k));
                }
            }

            dp[i].add(nums[i]);
            if (dp[i].size() > dp[maxIndex].size()) {
                maxIndex = i;
            }
        }

        return dp[maxIndex];
    }

    public static void main(String[] args) {
        largestDivisibleSubset(new int[]{1, 2, 3});
    }

}
