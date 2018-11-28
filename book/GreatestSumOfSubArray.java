package LeetCode.book;

/**
 * {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 */
public class GreatestSumOfSubArray {


    // 注意可能为负数,所以需要赋值为第一个
    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int globalMax = array[0], localMax = array[0];

        for (int i = 1; i < array.length; i++) {
            localMax = Math.max(localMax + array[i], array[i]);
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }
}
