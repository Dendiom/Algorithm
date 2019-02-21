package LeetCode.book;

/**
 * 二叉树的深度
 */
public class TreeDepth {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 树的最大深度
     */
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(1 + treeDepth(root.left), 1 + treeDepth(root.right));
    }

    /**
     * 树的最小深度
     */
    public int treeMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 已经是叶子节点，可确定深度
        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return 1 + treeMinDepth(root.right);
        }

        if (root.right == null) {
            return 1 + treeMinDepth(root.left);
        }

        return Math.min(1 + treeMinDepth(root.left), 1 + treeMinDepth(root.right));
    }
}
