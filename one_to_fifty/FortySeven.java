package LeetCode.one_to_fifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FortySeven {

    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, ans, new ArrayList<>(), new ArrayList<>());
        return ans;
    }

    /**
     * init a list of used index to replace temp.contains().
     * Time limit error!!!
     */
    private static void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> temp, List<Integer> used) {
        if (temp.size() == nums.length) {
            if (!ans.contains(temp)) {         // use this to avoid duplicate
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used.contains(i)) {
                continue;
            }

            temp.add(nums[i]);
            used.add(i);
            backtrack(nums, ans, temp, used);
            temp.remove(temp.size() - 1);
            used.remove(used.size() - 1);
        }
    }

    /**
     * my AC solution.
     */
    private static void backtrackTwo(int[] nums, List<List<Integer>> ans, List<Integer> temp, List<Integer> used) {
        boolean back = false;             // return from backtrack
        int remove = 0;
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used.contains(i) || (back && nums[i] == remove)) {  // important
                continue;
            }

            temp.add(nums[i]);
            used.add(i);
            backtrackTwo(nums, ans, temp, used);
            remove = temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
            used.remove(used.size() - 1);
            back = true;
        }
    }


    public static void main(String[] args) {
         System.out.println(permuteUnique(new int[]{3,3,1,2,3,2,3,1}));
    }
}
