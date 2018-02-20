package LeetCode.hundred_to_two;

import java.util.Map;
import java.util.Stack;

public class Four {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root, 0);
        //return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * Recursive approach.
     */
    private int helper(TreeNode root, int depth) {
       if (root == null) {
           return depth;
       }

       return Math.max(helper(root.left, depth + 1), helper(root.right, depth + 1));
    }

    /**
     * Iterative approach. 238ms...
     */
    private int maxDepthTwo(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> visit = new Stack<>();  // 1: visited left subtree, 2: visited both left & right.
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                visit.push(root.left == null && root.right == null ? 2 : 1);
                root = root.left;
            }

            depth = Math.max(depth, stack.size());

            if (visit.peek() == 1) {
                visit.pop();
                visit.push(2);
                root = stack.peek().right;
                continue;
            }

            while (!visit.isEmpty() && visit.peek() == 2) {
                visit.pop();
                root = stack.pop().right;
            }
        }

        return depth;
    }
}
