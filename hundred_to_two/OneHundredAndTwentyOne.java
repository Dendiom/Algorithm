package TestOne.hundred_to_two;


public class OneHundredAndTwentyOne {

    public static int maxPrice(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int maxProfit = 0;
        int minPrice = nums[0];
        for(int i =1;i<nums.length;i++){
            minPrice = Math.min(minPrice, nums[i]);
            maxProfit = Math.max(nums[i] - minPrice,maxProfit);
        }
        return maxProfit > 0?maxProfit:0;
    }

    public static void main(String[] args){
        System.out.println(maxPrice(new int[]{1,2,7,4,3,4}));
        System.out.println(maxPrice(new int[]{5,2,9,4,3,7}));
        System.out.println(maxPrice(new int[]{5,2,7,2,3,4}));
        System.out.println(maxPrice(new int[]{5,1,7,2,3,8}));
        System.out.println(maxPrice(new int[]{6,5,3,2,1}));
    }
}
