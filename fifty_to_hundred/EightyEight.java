package TestOne.fifty_to_hundred;


import java.util.Arrays;

public class EightyEight {

    public static int[] nums1 = new int[]{1, 2, 5,9,0,0,0};
    public static int[] nums2 = new int[]{2,4,5};

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = 0, b = 0, sum = 0;
        int[] temp = Arrays.copyOf(nums1, m);
        while (a < m && b < n)
            nums1[sum++] = temp[a] <= nums2[b] ? temp[a++] : nums2[b++];
        while (a < m)
            nums1[sum++] = temp[a++];
        while (b < n)
            nums1[sum++] = nums2[b++];

    }

    //another better way
    public static void mergeTwo(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1, b = n - 1, c = m + n - 1;
        while (a >= 0 && b >= 0) {
            nums1[c--] = nums1[a] >= nums2[b] ? nums1[a--] : nums2[b--];
        }
        while (b>=0){
            nums1[c--] = nums2[b--];
        }
    }

    public static void main(String[] args) {
        mergeTwo(nums1, 4, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
