package TestOne.two_hundred_to_three;

import java.awt.Container;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.omg.PortableServer.CurrentOperations;

public class Seventeen {

	// hashMap, 22ms
	public static boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> container = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (container.containsKey(nums[i]))
				return true;
			container.put(nums[i], 1);
		}
		return false;
	}

	// sort first, traverse array is faster
	public static boolean containsDuplicateWithSort(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				return true;
			}
		}
		return false;
	}
}
