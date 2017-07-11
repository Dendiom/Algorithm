package TestOne;


public class ThirtyFive {

    public static int searchInsert(int[] nums, int target) {
        int start = 0,end = nums.length - 1;
        while (start<=end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args){
        System.out.println(searchInsert(new int[]{1},1));
        System.out.println(searchInsert(new int[]{},4));
        System.out.println(searchInsert(new int[]{1,2,3},2));
        System.out.println(searchInsert(new int[]{1,2,3,5,7},8));
        System.out.println(searchInsert(new int[]{5,7,9},4));
    }
}

