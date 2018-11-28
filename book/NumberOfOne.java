package LeetCode.book;

/**
 * 输入一个整数，输出该数二进制表示中 1 的个数。
 */
public class NumberOfOne {


    /**
     * 位运算
     */
    public int numberOfOne(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n - 1);
            cnt++;
        }

        return cnt;
    }
}
