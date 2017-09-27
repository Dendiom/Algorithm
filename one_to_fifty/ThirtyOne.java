package TestOne.one_to_fifty;

import java.util.Arrays;
import java.util.concurrent.Exchanger;

public class ThirtyOne {

	/**
	 * find first desc sub array from the end, then exchange the found number
	 * with number which only bigger than it, finally reverse the array after
	 * the index of the found number
	 * 
	 * @param nums
	 */
	public static void nextPermutation(int[] nums) {
		int length = nums.length;
		if (length < 2)
			return;

		int temp = nums[length - 1];
		int tempIndex = length - 1;
		int leftIndex = length - 1;
		for (int i = length - 2; i >= 0; i--) {
			if (nums[i] >= temp) {
				temp = nums[i];
				tempIndex = i;
			} else {
				leftIndex = i;
				break;
			}
		}

		if (leftIndex == length - 1) { // reverse
			for (int i = 0; i < length / 2; i++) {
				exchange(nums, i, length - 1 - i);
			}
			return;
		}

		for (int i = leftIndex + 1; i < length; i++) {
			if (nums[i] > nums[leftIndex] && nums[i] <= temp) {
				temp = nums[i];
				tempIndex = i;
			}
		}

		// System.out.println(leftIndex);
		// System.out.println(tempIndex);
		exchange(nums, leftIndex, tempIndex);
		// System.out.println(Arrays.toString(nums));
		for (int i = 0; i < (length - 1 - leftIndex) / 2; i++) {
			exchange(nums, leftIndex + 1 + i, length - 1 - i);
		}
	}

	private static void exchange(int[] nums, int left, int right) {
		nums[left] = nums[left] + nums[right];
		nums[right] = nums[left] - nums[right];
		nums[left] = nums[left] - nums[right];
	}

	public static void main(String[] args) {
		int[] test = { 6, 6, 4, 3,2 };
		nextPermutation(test);
		System.out.println(Arrays.toString(test));
	}
}
