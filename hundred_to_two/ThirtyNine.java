package LeetCode.hundred_to_two;

import java.util.*;

public class ThirtyNine {

    /**
     * solution without dp:
     * use a bool array to store the result until Ith char of string s.
     */
    private static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;  // start with 0

        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("code","le","s","de")));
        System.out.println(wordBreak("leetcode", Arrays.asList("code","le","et")));
    }
}
