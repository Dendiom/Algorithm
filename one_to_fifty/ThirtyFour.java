package TestOne.one_to_fifty;


import java.util.Arrays;

public class ThirtyFour {

    //twice binary search

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        if(nums == null || nums.length == 0)
            return ans;
        int left = 0,right = nums.length-1;
        while(left<right){
            int mid = (left + right) /2;
            if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if(nums[left] == target)
            ans[0] = left;
        else
            return ans;
        right = nums.length - 1;
        while (left<right){
            int mid = (left + right)/2 + 1;             //important
            if(nums[mid]> target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        ans[1] = left;
        return ans;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 1, 1, 1, 4}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 3, 4}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 3, 4}, 5)));
    }
}


