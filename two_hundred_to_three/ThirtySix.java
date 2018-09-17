package LeetCode.two_hundred_to_three;

import java.util.LinkedList;
import java.util.Queue;

public class ThirtySix {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // my method
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        int count = exist(root.left, p.val, q.val);

        if (count == 0) { // both on the right
            return lowestCommonAncestor(root.right, p, q);
        }

        if (count == 1) { // one left one right
            return root;
        }

        if (count == 2) { // both on the left
            return lowestCommonAncestor(root.left, p, q);
        }

        return null;
    }

    public int exist(TreeNode root, int val1, int val2) {
        int ans = 0;
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == val1 || node.val == val2) {
                ans++;
                if (ans == 2) {
                    return ans;
                }
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return ans;
    }

    // better method
    public TreeNode lowestCommonAncestorBetter(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) { // one left one right
            return root;
        }

        if (left != null) { // all left
            return left;
        }

        // all right
        return right;
    }
}
