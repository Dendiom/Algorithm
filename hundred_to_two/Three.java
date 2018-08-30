package LeetCode.hundred_to_two;

import java.util.*;

public class Three {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        int level = 2; // start from 2
        Stack<TreeNode> odd = new Stack<>();
        Stack<TreeNode> even = new Stack<>();

        if (root != null) {
            odd.push(root);
        }

        while (!odd.empty() || !even.empty()) {
            List<Integer> temp = new ArrayList<>();
            if (level % 2 == 1) { // left -> right, use odd, from even
                while (!even.isEmpty()) {
                    TreeNode node = even.pop();
                    temp.add(node.val);
                    if (node.right != null) {
                        odd.push(node.right);
                    }

                    if (node.left != null) {
                        odd.push(node.left);
                    }
                }
            }

            if (level % 2 ==0) { // right -> left, use even, from odd
                while (!odd.empty()) {
                    TreeNode node = odd.pop();
                    temp.add(node.val);
                    if (node.left != null) {
                        even.push(node.left);
                    }

                    if (node.right != null) {
                        even.push(node.right);
                    }
                }
            }

            level++;
            ans.add(temp);
        }

        return ans;
    }
}
