package TestOne.hundred_to_two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class OneHundredAndSixtyNine {

	/**
	 * short enough, but not fast
	 */
	public static int majorityElementBySort(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	/**
	 * 
	 */
	public static int majorityElementByHashmap(int[] nums) {
		Map<Integer, Integer> store = new HashMap<>();
		if (nums.length < 3) {
			return nums[0];
		}
		int targetCount = (nums.length / 2) + 1;
		for (int num : nums) {
			if (store.containsKey(num)) {
				int count = store.get(num);
				System.out.println(count);
				if (++count == targetCount) {
					return num;
				}
				
				store.put(num, count);
			} else {
				System.out.println("first " + num);
				store.put(num, 1);
			}
		}
		return nums[0];  // can't reach 
	}

	public static void main(String[] args) {
		System.out.println(majorityElementByHashmap(new int[] { 1, 1, 3, 3, 3, 3,
				2, 1, 3 }));

	}

}
