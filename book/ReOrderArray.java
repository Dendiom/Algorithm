package LeetCode.book;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {


    /**
     * 需要新建一个数组，暂时没有找到空间O(1)的方法
     * 交换的方法无法保证相对位置不变
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int[] copy = array.clone();
        int index = 0;
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] % 2 != 0) {
                array[index++] = copy[i];
            }
        }

        for (int i = 0; i < copy.length; i++) {
            if (copy[i] % 2 == 0) {
                array[index++] = copy[i];
            }
        }
    }

    /**
     * 如果允许相对位置变化，则可以采用交换法
     */
    public static void reOrderArrayTwo(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            while (start < end && array[start] % 2 != 0) {
                start++;
            }

            while (start < end && array[end] % 2 == 0) {
                end--;
            }

            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 3, 5, 4, 9, 7, 3, 3};
        reOrderArrayTwo(array);
        System.out.println(Arrays.toString(array));
    }
}
