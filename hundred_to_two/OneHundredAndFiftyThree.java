package TestOne.hundred_to_two;


public class OneHundredAndFiftyThree {

    public static int findMin(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        if(nums[0]<=nums[right])
            return nums[0];
        while(left<right){
            int mid = (left+right)/2;
         //   System.out.println(mid);
            if(mid == 0) {
                return nums[0]>nums[1]?nums[1]:nums[0];
            }
            else if (nums[mid] > nums[0])
                left = mid + 1;
            else if (nums[mid] < nums[0])
                right = mid;            //maybe mid is the min
           // System.out.println("left: "+left);
            //System.out.println("right："+right);
        }
        return nums[left];
    }



    public static void main(String[] args){
        System.out.println(findMin(new int[] {1,3,6,7}));
        System.out.println(findMin(new int[] {1}));
       System.out.println(findMin(new int[] {4,6,7,1,2,3}));

        System.out.println(findMin(new int[] {7,2,3,5}));
        System.out.println(findMin(new int[] {3,5,7,1}));

    }
}
