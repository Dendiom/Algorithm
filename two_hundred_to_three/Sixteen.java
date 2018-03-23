package LeetCode.two_hundred_to_three;

import java.util.ArrayList;
import java.util.List;

public class Sixteen {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combine(ans, new ArrayList<>(), k, n, 1);
        return ans;
    }

    private void combine(List<List<Integer>> ans, List<Integer> temp, int k, int sum, int num) {
        if (sum < 0) {
            return;
        }

        if (temp.size() == k) {
            if (sum == 0) {
                ans.add(new ArrayList<>(temp));
            }

            return;
        }

        for (int i = num; i < 10; i++) {
            temp.add(i);
            combine(ans, temp, k, sum - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
