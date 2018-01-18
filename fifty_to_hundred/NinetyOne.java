package LeetCode.fifty_to_hundred;

public class NinetyOne {

    /**
     * Let x = decoding counts util the number before two numbers.
     * y = decoding counts util the number before current.
     * current = x + y or y, it depends on weather the two number's combination is in [1, 26].
     * pay attention to 0, it makes the question confused.
     */
    private static int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int twoBeforeCount = 1;
        int beforeCount = 1;
        int pre = Integer.valueOf(s.substring(0, 1));

        for (int i = 1; i < s.length(); i++) {
            int current = Integer.valueOf(s.substring(i, i + 1));
            if (current == 0) { // important
                if (pre > 2 || pre == 0) {
                    return 0;
                } else {
                    pre = current;
                    beforeCount = twoBeforeCount;
                    continue;
                }
            }

            if (pre != 0 && (pre * 10 + current) <= 26) {  // current = x + y
                int temp = beforeCount;
                beforeCount = beforeCount + twoBeforeCount;
                twoBeforeCount = temp;
            } else {
                twoBeforeCount = beforeCount;
            }
            pre = current;
        }
        return beforeCount;
    }

    /**
     *  Answer from LeetCode.
     */
    private static int numDecodingsTWo(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1]; // init a zero array
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') // dp[i] = 0, two consecutive 0 will return 0
                dp[i] = dp[i - 1];
            if (i > 1) {
                if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                    dp[i] += dp[i - 2];  // current = x + y, the same way as I do
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("17124"));
        System.out.println(numDecodings("110"));
    }
}
