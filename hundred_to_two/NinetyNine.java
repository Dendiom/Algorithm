package LeetCode.hundred_to_two;

import java.util.*;

public class NinetyNine {
    private final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * DFS
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int maxDepth = -1;

        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                if (!map.containsKey(depth)) {
                    map.put(depth, node.val);
                }

                maxDepth = Math.max(depth, maxDepth);
                nodeStack.push(node.left);
                depthStack.push(++depth);
                nodeStack.push(node.right);
                depthStack.push(depth);
            }
        }

        for (int i = 0; i <= maxDepth; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }

    /**
     * Better approach.
     */
    public List<Integer> rightSideViewTwo(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        getRightView(root, 0, ans);
        return ans;
    }

    private void getRightView(TreeNode root, int currentDepth, List<Integer> result){
        if(root == null) {
            return;
        }

        if(currentDepth == result.size()){
            result.add(root.val);
        }

        getRightView(root.right, currentDepth + 1, result);
        getRightView(root.left, currentDepth + 1, result);
    }

}
