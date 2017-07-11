package TestOne.one_to_fifty;

import java.util.Arrays;


public class Sixteen {

    public static int threeSumCloset(int[] nums,int target) {
        int i ,j = nums.length-1;
        int ans = nums[0]+nums[1] + nums[j];  //init ans
        Arrays.sort(nums);
        for (i = 0;i<j-1;i++){
            int start = i+1;
            int end = j;
            int realTarget = target - nums[i];
            System.out.println("real:"+realTarget);
            while (start<end) {
                if (nums[start] + nums[end] == realTarget)
                    return target;
                if(nums[start] + nums[end] > realTarget){
                    ans = nums[start] + nums[end] - realTarget > Math.abs(ans - target)? ans:nums[start] + nums[end] + nums[i];
                    System.out.println(">:"+ans);
                    end--;
                } else {
                    ans = realTarget - nums[start] - nums[end] > Math.abs(ans - target)? ans:nums[start] + nums[end] + nums[i];
                    System.out.println("<:"+ans);
                    start++;
                }
            }

        }
        return ans;
    }


    public static void main(String[] args){
        System.out.println(threeSumCloset(new int[]{-4,-1,1,2},1));
       // System.out.println(threeSumCloset(new int[]{2,4,-2,4,9,-3},8));
       // System.out.println(threeSumCloset(new int[]{2,4,-2,4,9,-3},18));
    }
}
