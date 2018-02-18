package LeetCode.hundred_to_two;

import java.util.*;

public class FortyFour {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Recursive preorder traversal.
     *  middle -> left -> right
     */
    private List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorderHelper(root, ans);
        return ans;
    }

    private void preorderHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.val);
        preorderHelper(root.left, ans);
        preorderHelper(root.right, ans);
    }

    /**
     * Iteratively preorder traversal.
     */
    private List<Integer> preorderTraversalTwo(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                ans.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop().right;
        }

        return ans;
    }
}
