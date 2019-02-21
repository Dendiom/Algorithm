package LeetCode.book;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S。
 * 如果有多对数字的和等于 S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {

    /**
     * 采用双指针向中间移动，第一组满足条件的数乘积一定最小
     */
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) {
            return result;
        }

        int start = 0, end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] == sum) {
                result.add(array[start]);
                result.add(array[end]);
                return result;
            }

            if (array[start] + array[end] > sum) {
                end--;
            } else {
                start++;
            }
        }

        return result;
    }
}
