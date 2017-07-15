package TestOne.one_to_fifty;


public class TwentySix {

    public static int deleteDuplicates(int[] nums){
        int lens = nums.length,ans = 1;
        if(lens<2)
            return lens;
        for(int i = 0;i<lens-1;i++){
            if(nums[i] != nums[i+1]) {
                nums[ans] = nums[i+1];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(deleteDuplicates(new int[]{1,1,2,2,3,5,5,5,7}));
        System.out.println(deleteDuplicates(new int[]{1,1,1,1,3}));
        System.out.println(deleteDuplicates(new int[]{1}));
    }
}
