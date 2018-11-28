package LeetCode.book;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNumber {

    // 经典的投票法
    public int moreThanHalfNumber(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int count = 0;
        int majority = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == majority) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majority = array[i];
                    count = 1;
                }
            }
        }

        // 可能无解，所以需要再验证一遍
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == majority) {
                count++;
            }
        }

        return count > array.length / 2 ? majority : 0;
    }
}
