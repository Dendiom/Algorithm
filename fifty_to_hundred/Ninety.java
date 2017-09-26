package TestOne.fifty_to_hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ninety {

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(nums, new ArrayList<>(), ans, 0);
		return ans;

	}
	
	private static void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> ans, int start) {
		ans.add(new ArrayList<Integer>(temp));
		
		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			backtrack(nums, temp, ans, i + 1);
		 
			while (i < nums.length - 1  && nums[i] == nums[i + 1] ) {  // pop == next, pass
				i++;
			}
			temp.remove(temp.size() - 1);
		}
		
	}

	public static void main(String[] args) {
		System.out.println(subsetsWithDup(new int[]{1, 2 ,2, 3}));
	}

}
