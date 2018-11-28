package LeetCode.book;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class PathSum {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 典型的回溯法
     */
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        find(result, new ArrayList<>(), target, root);
        return result;
    }

    public void find(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int target, TreeNode node) {
        if (node == null) {
            return;
        }

        temp.add(node.val);
        target = target - node.val;
        if (target == 0 && node.left == null && node.right == null) {   // 必须要是叶子节点，才满足题目要求
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }

        find(result, temp, target, node.left);
        find(result, temp, target, node.right);
        temp.remove(temp.size() - 1);
    }

}
