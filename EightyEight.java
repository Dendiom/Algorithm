package TestOne;


import java.util.Arrays;

public class EightyEight {

    public static int[] nums1 = new int[]{1,2,5,0};
    public static int[] nums2 = new int[]{2};

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = 0, b = 0, sum = 0;
        int[] temp = Arrays.copyOf(nums1,m);
        while (a < m && b < n)
            nums1[sum++] = temp[a] <= nums2[b] ? temp[a++] : nums2[b++];
        if(b == n){
            while (a<m)
                nums1[sum++] = temp[a++];
        }
        if(a == m){
            while (b<n)
                nums1[sum++]  = nums2[b++];
        }
    }


    public static void main(String[] args) {
        merge(nums1, 3, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
