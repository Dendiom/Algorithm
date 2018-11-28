package LeetCode.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class ZigzagPrint {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 简单的层序遍历，使用一个队列即可
     */
    public ArrayList<ArrayList<Integer>> zigzagPrint(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;
        while(!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int count = queue.size();
            while (count > 0) {
                count--;
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (reverse) {
                Collections.reverse(level);
            }
            reverse = !reverse;
            result.add(level);
        }

        return result;
    }
}
