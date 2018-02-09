package LeetCode.fifty_to_hundred;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class NinetyFive {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Similar to NinetySix.
     * Let i in (1, n) be the root node, then combine the left and right.
     */
    private static List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp = new List[n + 1];
        dp[0] = new ArrayList<>();
        if (n < 1) {
            return dp[0];
        }
        dp[0].add(null);
        dp[1] = new ArrayList<>();
        dp[1].add(new TreeNode(1));
        for (int i = 2; i < n + 1; i++) {
            dp[i] = new ArrayList<>();
            for (int j = 1; j < i + 1; j++) {
                for (TreeNode left : dp[j - 1]) {   // current node's left trees
                    for (TreeNode right : dp[i - j]) {  // current node's right trees
                        TreeNode root = new TreeNode(j);
                        root.left = left;
                        root.right = combine(right, j);
                        dp[i].add(root);
                    }
                }
            }
        }

        return dp[n];
    }

    /**
     * Auxiliary function.
     * clone trees with offset(val = val + offset).
     */
    private static TreeNode combine(TreeNode node, int offset) {
        if (node == null) {
            return null;
        }

        TreeNode newNode = new TreeNode(node.val + offset);
        newNode.left = combine(node.left, offset);
        newNode.right = combine(node.right, offset);
        return newNode;
    }

    public static void main(String[] args) {
        //System.out.println(generateTrees(1).size());
        //System.out.println(generateTrees(2).size());
        System.out.println("length: " + generateTrees(3).size());
    }
}
