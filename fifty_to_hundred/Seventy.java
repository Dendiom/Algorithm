package LeetCode.fifty_to_hundred;

public class Seventy {

    /**
     * dynamic programming.
     * use array.
     */
    private static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;
        for (int i = 2; i < n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }

        return steps[n - 1];
    }

    /**
     * no array.
     */
    private static int climbStairsNoArray(int n) {
        if (n <= 2) {
            return n;
        }

        int ppre = 1, pre = 2, ans = 0;
        for (int i = 0; i < n - 2; i++) {
            ans = pre + ppre;
            ppre = pre;
            pre = ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(9));
    }
}
