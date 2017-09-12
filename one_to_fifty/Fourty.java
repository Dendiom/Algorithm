package TestOne.one_to_fifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fourty {

	public static List<List<Integer>> combinationSum2(int[] candidates,
			int target) {
		ArrayList<List<Integer>> ans = new ArrayList<>();
		if (candidates == null || candidates.length == 0)
			return ans;

		Arrays.sort(candidates);
		backtrack(candidates, target, ans, new ArrayList<Integer>(), 0);
		return ans;
	}

	private static void backtrack(int[] candidates, int target,
			ArrayList<List<Integer>> ans, List<Integer> temp, int index) {
		if (target < 0)
			return;
		if (target == 0) { // find an answer
			ans.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if(i > index && candidates[i] == candidates[i - 1])  // can't be index here, index means layer of recursing 
				continue;
			temp.add(candidates[i]);
			System.out.println(temp);
			backtrack(candidates, target - candidates[i], ans, temp, i + 1);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum2(new int[] { 1, 3, 3, 5 }, 8));
	}

}
