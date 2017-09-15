package TestOne.fifty_to_hundred;


import java.util.ArrayList;
import java.util.List;

public class SeventyEight {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return ans;
        backtrack(ans, nums, new ArrayList<>(), 0);
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, int[] nums ,List<Integer> temp, int start) {
        ans.add(new ArrayList<>(temp));
        for (int i = start;i < nums.length ; i++) {
            temp.add(nums[i]);
            backtrack(ans, nums, temp, i + 1);        // no duplicate
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1,2,3}));
    }
}
