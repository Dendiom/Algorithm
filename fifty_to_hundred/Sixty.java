package LeetCode.fifty_to_hundred;

import java.util.LinkedList;
import java.util.List;

public class Sixty {


    public String getPermutation(int n, int k) {
        StringBuilder ans = new StringBuilder("");
        recursion(ans, new boolean[n], n, k, new int[1]);
        return ans.toString();

    }

    /**
     * Recursive method, it cost so much time.
     */
    private boolean recursion(StringBuilder ans, boolean[] visit, int n, int k, int[] now) {
        if (ans.length() == n) {
            now[0]++;
            return now[0] == k;
        }

        for (int i = 1; i <= n; i++) {
            if (visit[i - 1]) {
                continue;
            }

            ans.append(i);
            visit[i - 1] = true;

            if (recursion(ans, visit, n, k, now)) {
                return true;
            }

            int lastIndex = ans.length() - 1;
            visit[ans.charAt(lastIndex) - '0' - 1] = false;
            ans.deleteCharAt(lastIndex);
        }

        return false;
    }

    /**
     * https://leetcode.com/problems/permutation-sequence/discuss/22508/An-iterative-solution-for-reference
     */
    public String getPermutationTwo(int n, int k) {
        List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }

        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = i*fact[i-1];
        }

        k = k-1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--){
            int ind = k/fact[i-1];
            k = k%fact[i-1];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Sixty().getPermutation(3, 3));
    }

}
