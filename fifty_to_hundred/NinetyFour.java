package LeetCode.fifty_to_hundred;


import org.omg.CORBA.INTERNAL;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NinetyFour {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * recursive inorder traversal.
     *  left -> middle -> right.
     */
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderHelper(root, ans);
        return ans;
    }

    private void inorderHelper(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }

        inorderHelper(node.left, ans);
        ans.add(node.val);
        inorderHelper(node.right, ans);
    }

    /**
     * iterative inorder traversal.
     */
    private List<Integer> inorderTraversalTwo(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }

        return ans;
    }
}
