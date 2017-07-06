package TestOne;

public class FiftyThree {
	
	public static int maxSubArray(int[] nums) {
		if( nums  == null || nums.length == 0){
			return 0;
		}
		int globalMax = nums[0], localMax = nums[0];
		for(int i = 1 ;i<nums.length;i++){
			localMax = Math.max(localMax + nums[i], nums[i]);
			globalMax = Math.max(globalMax, localMax);
		}
		return globalMax;
	
	}

	
	
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-1,2,4,-4,3}));
		System.out.println(maxSubArray(new int[]{-4,2,-4,4,3}));
		System.out.println(maxSubArray(new int[]{-1,-2,4,4,-3}));
	}

}
