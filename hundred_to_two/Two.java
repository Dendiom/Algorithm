package LeetCode.hundred_to_two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Two {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Using two queues.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue  = new LinkedList<>();
        Queue<Integer> depthQ = new LinkedList<>();
        queue.offer(root);
        depthQ.add(1);
        List<Integer> temp = new ArrayList<>();
        int depthTemp = 1;

        while (!queue.isEmpty()) {
            TreeNode node  = queue.poll();
            int depth = depthQ.poll();

            if (depth == depthTemp) {
                temp.add(node.val);
            } else {
                ans.add(temp);
                temp = new ArrayList<>();
                temp.add(node.val);
                depthTemp = depth;
            }

            depth++;
            if (node.left != null) {
                queue.offer(node.left);
                depthQ.offer(depth);
            }

            if (node.right != null) {
                queue.offer(node.right);
                depthQ.offer(depth);
            }
        }

        ans.add(temp);
        return ans;
    }

    /**
     * Using one queue.
     */
    public List<List<Integer>> levelOrderTwo(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> temp = new ArrayList<>();

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i ++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(temp);
            temp = new ArrayList<>();
        }

        return ans;
    }
}
