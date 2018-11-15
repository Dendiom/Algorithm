package LeetCode.book;

import java.util.Arrays;

/**
 * 题目：找出数组中重复的数字
 * 描述：在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 */
public class DuplicateInArray {

    /**
     * 允许修改原数组
     * 将每位的值移动到i位置上
     */
    public static boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length < 2) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            while (i != numbers[i]) {
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }

                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        return false;
    }

    /**
     * 允许修改原数组
     * 先排序，然后一个个比较 O(nlogn + n)
     */
    private static boolean duplicateTwo(int[] numbers, int length, int[] duplication) {
        if (numbers == null) {
            return false;
        }

        Arrays.sort(numbers);
        for (int i = 1; i < length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }

        return false;
    }

    /**
     * 不修改原数组情况下，使用二分法查找，注意这种算法只能用于 1~n，n+1长度的情况！0~n-1，n情况不行
     */
    public static boolean duplicateThree(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length < 2) {
            return false;
        }

        int start = 0, end = length - 1;
        while (start < end) {
            int mid = (start + end) >> 1;
            int num = count(numbers, start, mid);
            if (num >  mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        duplication[0] = numbers[start];
        return true;
    }


    public static int count(int[] numbers, int min, int max) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] <= max && numbers[i] >= min) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(duplicateThree(new int[]{1,2,2,3,4},5, new int[1]));
        System.out.println(duplicateThree(new int[]{1,1,3,3,4},5, new int[1]));
    }
}

