package TestOne.one_to_fifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirtyNine {
	
	//backtrack, target and candidates are positive integer  is very important.

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack(ans, new ArrayList<Integer>(), candidates, target, 0);
		return ans;
	}
	
	private static void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int target, int start){
		if (target < 0)
			return;
		if (target == 0)
			ans.add(new ArrayList<Integer>(temp));
		else {
			for (int i = start; i < candidates.length; i++) {
				temp.add(candidates[i]);
				backtrack(ans, temp, candidates, target - candidates[i], i);
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[]{1,4,5,2,3}, 4));
	}

}
