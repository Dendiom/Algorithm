package LeetCode.hundred_to_two;

import java.util.ArrayList;
import java.util.List;

public class Thirteen {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(root, sum, ans, new ArrayList<>());
        return ans;
    }

    private void backtrack(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> temp) {
        if (root == null) {
            temp.add(null);  // important
            return;
        }

        temp.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        backtrack(root.left, sum - root.val, ans, temp);
        temp.remove(temp.size() - 1);
        backtrack(root.right, sum - root.val, ans, temp);
        temp.remove(temp.size() - 1);
    }
}
