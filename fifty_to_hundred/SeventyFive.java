package TestOne.fifty_to_hundred;


import java.util.Arrays;

public class SeventyFive {


    public static void sortColorsBest(int[] nums) { // 0ms solution from leetcode
        if (nums == null || nums.length <= 1)
            return;
        int red = 0;
        int blue = nums.length - 1;
        for (int i = 0; i <= blue; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[red];
                nums[red++] = temp;
                System.out.println(Arrays.toString(nums));
            }
            else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i--] = nums[blue];    // i-- is important
                nums[blue--] = temp;
                System.out.println(Arrays.toString(nums));
            }
        }
    }

    public static void sortColors(int[] nums) { // only traverse one time , but confused......
        if (nums == null || nums.length <= 1)
            return;
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < right - 1; i++) {
            if (nums[i] == 0) {
                if (i > left)
                    swap(nums, i, left++);
                else
                    left++;
            } else if (nums[i] == 2 && i < right) {
                while (i < right && nums[right] == 2) {
                    right--;
                }
                swap(nums, i, right--);
                if (nums[i] == 0)
                    if (i > left)
                        swap(nums, i, left++);
                    else
                        left++;
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void sortColorsTwo(int[] nums) {    // scan and place, traverse two times
        if (nums == null || nums.length <= 1)
            return;
        int w = 0;
        int r = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    w++;
                    break;
                case 1:
                    r++;
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < w)
                nums[i] = 0;
            else if (i < w + r) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public static void sortColorsWithQS(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int left, int right) { // just a practice for quick sort, not fit this question
        if (left >= right)
            return;
        int start = left;
        int end = right;
        int temp = nums[left]; // first element as key
        while (start < end) {
            while (start < end && nums[end] >= temp)
                end--;
            nums[start] = nums[end];
            while (start < end && nums[start] <= temp)
                start++;
            nums[end] = nums[start];
        }
        nums[start] = temp;
        quickSort(nums, left, start - 1);
        quickSort(nums, start + 1, right);
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,0,0,2};
        sortColorsBest(a);
        System.out.println(Arrays.toString(a));
    }
}
