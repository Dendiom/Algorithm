package LeetCode.book;

import java.util.Arrays;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
 */
public class PrintMinNumber {


    /**
     * 另类的排序问题，s1 + s2 <= s2 + s1时，将s1排在s2前面
     */
    public String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }

        String[] numStrs = new String[numbers.length];
        for (int i = 0 ; i < numbers.length; i++) {
            numStrs[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numStrs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str: numStrs) {
            sb.append(str);
        }

        return sb.toString();
    }
}
