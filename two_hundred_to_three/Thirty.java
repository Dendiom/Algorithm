package LeetCode.two_hundred_to_three;

import java.util.Stack;

public class Thirty {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // inorder traversal
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 1;

        while(root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                if (k == count) {
                    return node.val;
                }
                count++;
                root = node.right;
            }
        }

        return 0;
    }
}
