package LeetCode.book;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的各种遍历
 */
public class TreeTraversals {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 前序遍历，递归版
     */
    public static void preorderRecursive(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preorderRecursive(node.left);
        preorderRecursive(node.right);
    }

    /**
     * 中序遍历，递归版
     */
    public static void inorderRecursive(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderRecursive(node.left);
        System.out.print(node.val + " ");
        inorderRecursive(node.right);
    }

    /**
     * 后序遍历，递归版
     */
    public static void postorderRecursive(TreeNode node) {
        if (node == null) {
            return;
        }

        postorderRecursive(node.left);
        postorderRecursive(node.right);
        System.out.print(node.val + " ");
    }

    /**
     * 前序遍历，非递归版
     */
    public static void preorderNormal(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode cur = null;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur != null) {
                System.out.print(cur.val + " ");
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历，非递归版
     */
    public static void inorderNormal(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * 后序遍历，非递归版
     */
    public static void postorderNormal(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        TreeNode pre = null; // 需要记录前一个访问的节点，不然会重复访问
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.peek();
            if (cur.right != null && cur.right != pre) {  // 避免重复访问
                cur = cur.right;
            } else {
                System.out.print(cur.val + " ");
                pre = cur;
                stack.pop();
                cur = null;
            }
        }
        System.out.println();
    }

    /**
     * 层序遍历
     */
    public static void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur != null) {
                System.out.print(cur.val + " ");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }

        System.out.println();
    }

    public static TreeNode generateTree(int[] nodes, int rootIndex) {
        if (rootIndex >= nodes.length || nodes
                [rootIndex] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[rootIndex]);
        root.left =  generateTree(nodes, rootIndex * 2 + 1);
        root.right = generateTree(nodes, rootIndex * 2 + 2);
        return root;
    }

    public static void test(int[] nodes) {
        TreeNode root = generateTree(nodes, 0);
        System.out.print("前序遍历： ");
        preorderRecursive(root);
        System.out.println();
        System.out.print("前序遍历： ");
        preorderNormal(root);
        System.out.print("中序遍历： ");
        inorderRecursive(root);
        System.out.println();
        System.out.print("中序遍历： ");
        inorderNormal(root);
        System.out.print("后序遍历： ");
        postorderRecursive(root);
        System.out.println();
        System.out.print("后序遍历： ");
        postorderNormal(root);
        System.out.print("层序遍历： ");
        levelOrder(root);
    }

    public static void main(String[] args) {
        test(new int[]{1,2,3, 6, -1, 6, -1, 3});
    }
}
