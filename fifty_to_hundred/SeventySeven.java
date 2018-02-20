package LeetCode.fifty_to_hundred;

import java.util.ArrayList;
import java.util.List;

public class SeventySeven {

    private List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), n, k, 1);
        return ans;

    }

    private void backtrack(List<List<Integer>> ans, List<Integer> temp, int n, int k, int start) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start ; i <= n; i++) {
            temp.add(i);
            backtrack(ans, temp, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
