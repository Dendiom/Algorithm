package LeetCode.fifty_to_hundred;

public class NinetySIx {

    /**
     * My solution:
     *   for example:
     *   n = 3;
     *   let 1, 2, 3 be the head node.
     *   treeHead(1) = tree(2, 3) = dp[2];
     *   treeHead(2) = tree(1) * tree(3) = dp[1] * dp[3];
     *   treeHead(3) = tree(2, 3) = dp[2];
     */
    private static int numTrees(int n) {
        if (n < 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
        System.out.println(numTrees(5));
    }
}
