package TestOne.hundred_to_two;

import java.util.Arrays;

public class SixtySeven {

	/**
	 * array is sorted, so we can search from border to middle.
	 */
	public static int[] twoSum(int[] numbers, int target) {
		int[] ans = new int[2];    // question detail says that there must be an answer
		int start = 0;
		int end = numbers.length - 1;
		while (true) {
			if (numbers[start] + numbers[end] == target) {
				ans[0] = start + 1;
				ans[1] = end + 1;
				return ans;
			} else if (numbers[start] + numbers[end] > target) {
				end--;
			} else {
				start++;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 1, 2 }, 3)));
		System.out.println(Arrays.toString(twoSum(new int[] { 1, 2, 7, 9 }, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] { 1, 5, 6, 12, 15 }, 17)));
	}

}
