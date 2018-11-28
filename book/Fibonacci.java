package LeetCode.book;

/**
 * 求斐波那契数列的第 n 项，n <= 39。
 * f(0) = 0, f(1) = 1 f(n) = f(n - 1) + f(n - 2)
 */
public class Fibonacci {

    /**
     * 递归算法，有大量重复运算，效率不高
     */
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**
     * 动态规划，不需要dp[]，可以节约内存
     */
    public int FibonacciTwo(int n) {
        if (n < 2) {
            return n;
        }

        int one = 0, two = 1;
        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one = two;
            two = temp + two;
        }

        return two;
    }
}
