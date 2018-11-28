package LeetCode.book;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 与下一题完全相同：
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，
 * 总共有多少种方法？
 */
public class JumpFloor {

    /**
     * 动态规划 dp[n]=dp[n -1]+dp[n -2]类似于Fibonacci数列
     */
    public int JumpFloor(int n) {
        if (n <= 2) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * 不使用数组，只存储两位
     */
    public int JumpFloorTwo(int n) {
        if (n <= 2) {
            return n;
        }

        int one = 1, two = 2;
        for (int i = 0; i < n - 2; i++) {
            int temp = one;
            one = two;
            two = temp + two;
        }

        return two;
    }

    /**
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
     *
     * dp[n] = dp[1] + dp[2] + dp[3] + ... + dp[n - 1]
     */
    public int JumpFloorII(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }

        return dp[n];
    }
}
