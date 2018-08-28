package LeetCode.hundred_to_two;

public class Fourteen {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Recursive
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten(left);
        flatten(right);

        // make up
        if (left == null) {
            return;
        }

        TreeNode end = left;
        while (end.right != null) {
            end = end.right;
        }

        end.right = root.right;
        root.right = left;
        root.left = null;
    }
}
