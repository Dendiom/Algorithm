package LeetCode.book;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *
 * 例如数组 {3, 4, 5, 1, 2} 为 {1, 2, 3, 4, 5} 的一个旋转，该数组的最小值为 1。
 * 假设数组元素不允许重复 (如果假设元素允许重复，那么需要在nums[start] = nums[mid] = nums[end]时进行顺序查找)
 */
public class MinNumberInRotateArray {

    /**
     * 二分法
     */
    public static int minNumberInRotateArray(int[] array) {
        int end = array.length - 1;
        int start = 0;
        if (end < 0) {
            return 0;
        }

        // 完全没有旋转
        if (array[start] < array[end]) {
            return array[start];
        }

        while (start < end) {
            int mid = (start + end) >> 1;
            if (array[mid] > array[start]) {
                start = mid + 1;
            } else if (array[mid] < array[start]){
                end = mid;
            } else {   // mid == start
                return Math.min(array[start], array[end]);
            }
        }

        return array[start];
    }

    public static void main(String[] args) {
        System.out.println(minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minNumberInRotateArray(new int[]{3, 4, 5}));
        System.out.println(minNumberInRotateArray(new int[]{5, 1, 2, 3, 4}));
        System.out.println(minNumberInRotateArray(new int[]{9, 1, 2, 3, 4, 6}));
        System.out.println(minNumberInRotateArray(new int[]{10, 11, 12, 3, 4, 6, 9}));
    }
}
