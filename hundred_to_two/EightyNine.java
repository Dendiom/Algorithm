package TestOne.hundred_to_two;


import java.util.Arrays;

public class EightyNine {

    //o(1) extra space
    // k maybe more than nums.length

    private static int[] nums = {1,2};
    public static void move(int nums[], int k){

        if(nums == null || nums.length <2)
            return;
        k = k % nums.length;
        reverse(nums, nums.length - k,nums.length - 1);
        reverse(nums, 0,nums.length - 1 - k);
        reverse(nums,0,nums.length -1);
    }

    private static void reverse(int nums[], int left, int right){
        while (left < right){
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

    public static void main(String[] args){
        move(nums,5);
        System.out.println(Arrays.toString(nums));
    }
}
