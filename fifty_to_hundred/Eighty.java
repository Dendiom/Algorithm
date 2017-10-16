package TestOne.fifty_to_hundred;

import java.util.Arrays;

public class Eighty {

	public static int removeDuplicates(int[] nums) {
		int length = nums.length;
		int dup = 1;
		int ans = 1;
		if (length < 3) {
			return length;
		}

		for (int i = 1; i < length; i++) {
			if (nums[i] != nums[i-1]) {
				nums[ans++] = nums[i];
				dup = 1;
			} else if (dup == 1) {
				nums[ans++] = nums[i];
				dup++;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,1,2,3,3,3,4,4}));
		System.out.println(removeDuplicates(new int[]{1,1,1,1,2,2,3,4}));
		System.out.println(removeDuplicates(new int[]{1,1,1,1,2,3,4,5,5,5}));
	}
}
