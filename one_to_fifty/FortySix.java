package LeetCode.one_to_fifty;

import java.util.ArrayList;
import java.util.List;

public class FortySix {

    /**
     * backtrack.
     */
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, new ArrayList<>());
        return ans;
    }

    private static void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> temp) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int num: nums) {
            if (temp.contains(num)) {
                continue;
            }

            temp.add(num);
            backtrack(nums, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {

    }
}
