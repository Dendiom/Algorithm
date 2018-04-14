package TestOne.hundred_to_two;

import java.util.ArrayList;
import java.util.List;

public class Twenty {

	public static int minimumTotal(List<List<Integer>> triangle) {
		// if (triangle == null)
		// return 0;
		int length = triangle.size();
		if (length == 0)
			return 0;
		if (length == 1)
			return triangle.get(0).get(0);
		int[] ans = new int[length + 1];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < length + 1; i++) {
			ans[i] = Integer.MAX_VALUE;
		}
		ans[1] = triangle.get(0).get(0);
		for (int i = 1; i < length; i++) {
			for (int j = i + 1; j > 0; j--) {
				ans[j] = Math.min(ans[j], ans[j-1]) + triangle.get(i).get(j - 1);
				if (i == length - 1 && min > ans[j]) {
					min = ans[j];
				}
			}
		}
		return min;
	}

	public static int minimumTotalTooSlow(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
		List<Integer> ans = new ArrayList<>();
		ans.add(Integer.MAX_VALUE);
		backtrack(triangle, ans, 0, 0, 0);
		return ans.get(0);
	}

	private static void backtrack(List<List<Integer>> triangle,
			List<Integer> ans, // Time Limit Exceeded....So sad
			int temp, int row, int start) {
		temp = temp + triangle.get(row).get(start);
		if (row == triangle.size() - 1) {
			if (ans.get(0) > temp) {
				ans.set(0, temp);
			}
			return;
		}
		backtrack(triangle, ans, temp, row + 1, start);
		backtrack(triangle, ans, temp, row + 1, ++start);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub;

		System.out.println();

	}

}
