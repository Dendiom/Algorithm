package LeetCode.two_hundred_to_three;

import java.util.ArrayList;
import java.util.List;

public class FiftySeven {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        recursive(ans, root, "");
        return ans;
    }

    public void recursive(List<String> ans, TreeNode root, String temp) {
        temp += root.val + "->";
        if (root.left == null && root.right == null) {
            ans.add(temp.substring(0, temp.length() - 2));
            return;
        }

        if (root.left != null) {
            recursive(ans, root.left, temp);
        }

        if (root.right != null) {
            recursive(ans, root.right, temp);
        }
    }
}
