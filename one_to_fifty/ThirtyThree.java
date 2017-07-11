package TestOne;


public class ThirtyThree {

    public static int search(int[] nums,int target){
        //首先找到反转点
        int left = 0;
        int right = nums.length - 1;
        if(right<0)
            return -1;
        int start = nums[0];
        while (left<right){
            int mid = (left + right)/2;
            if(start>nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        int reverse = left;
        //二分法
        if(target>=start){
            left = 0;
            right = reverse;
        } else {
            left = reverse;
            right = nums.length - 1;
        }
        while (left<=right){
            int mid = (left+right)/2;
            if(target == nums[mid])
                return mid;
            if(target>nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(search(new int[]{2,1},2));
        System.out.println(search(new int[]{8,5,6,7},8));
//        System.out.println();
//        System.out.println();
    }
}
