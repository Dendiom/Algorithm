package LeetCode.book;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintBinaryTreeFromTopToBottom {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 层序遍历，使用一个队列
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return result;
    }

}
