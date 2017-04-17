package TestOne;

import java.util.HashMap;
import java.util.Map;


public class One {

    // only one solution,not sorted,return indices
    public static int[] twoSumReturnIndices(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> store = new HashMap<Integer, Integer>();
        store.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (store.containsKey(target - nums[i])) {
                ans[0] = store.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            store.put(nums[i],i);
        }
        return ans;
    }

    public static void main(String[] args){

    }
}
