package TestOne.one_to_fifty;


public class TwentySeven {

    public static int deleteElement(int[] nums,int val){
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != val){
                nums[ans] = nums[i];
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args){
        System.out.println(deleteElement(new int[]{3,2,2,4,5},3));
    }
}
