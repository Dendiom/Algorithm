package LeetCode.book;

/**
 * 不用加减乘除做加法
 */
public class Add {

    /**
     * a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位。
     */
    public int add(int a, int b) {
        return b == 0 ? a : add(a ^ b, (a & b) << 1);
    }
}
