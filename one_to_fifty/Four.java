package LeetCode.one_to_fifty;

public class Four {

    //o(m + n)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int target1 = 0, target2 = 0;
        if ((m + n) % 2 == 0) {
            target1 = (m + n) / 2 - 1;
            target2 = target1 + 1;
        } else {
            target1 = (m + n) / 2;
        }

        int index1 = 0, index2 = 0, count = -1;
        while (index1 < m && index2 < n) {
            if (nums1[index1] <= nums2[index2]) {
                count++;
                if (count == target1) {
                    target1 = nums1[index1];
                    if (target2 == 0) {
                        return target1;
                    } else {
                        if (index1 + 1 < m) {
                            target2 = Math.min(nums1[index1 + 1], nums2[index2]);
                        } else {
                            target2 = nums2[index2];
                        }

                        return (target1 + target2) / 2.0;
                    }
                }
                index1++;
            } else {
                count++;
                if (count == target1) {
                    target1 = nums2[index2];
                    if (target2 == 0) {
                        return target1;
                    } else {
                        if (index2 + 1 < n) {
                            target2 = Math.min(nums1[index1], nums2[index2 + 1]);
                        } else {
                            target2 = nums1[index1];
                        }

                        return (target1 + target2) / 2.0;
                    }
                }
                index2++;
            }
        }

        count++;
        if (index1 == m) {
            while (count < target1) {
                count++;
                index2++;
            }
            return target2 == 0? nums2[index2] : (nums2[index2] + nums2[index2 + 1]) / 2.0;
        } else {
            while (count < target1) {
                count++;
                index1++;
            }
            return target2 == 0? nums1[index1] : (nums1[index1] + nums1[index1 + 1]) / 2.0;
        }

    }

    public static double brief(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int index1 = 0, index2 = 0;
        int first = 0, second = 0;
        for (int i = 0; i <= len / 2; i++) {
            first = second;
            if (index1 < m &&  (index2 >= n || nums1[index1] <= nums2[index2])) {
                second = nums1[index1++];
            } else {
                second = nums2[index2++];
            }
        }

        if (len % 2 == 0) {
            return (first + second) / 2.0;
        }

        return second;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3,5}, new int[]{}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1,6}));
        System.out.println(brief(new int[]{}, new int[]{1,6}));
        System.out.println(brief(new int[]{1, 6, 7 }, new int[]{1,6}));
    }
}
