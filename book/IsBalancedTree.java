package LeetCode.book;

/**
 * 判断是否是平衡二叉树
 */
public class IsBalancedTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    // 一个点一个点的判断，这个点满足条件之后再判断其左右节点是否满足条件
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        return root == null ? 0 : Math.max(1 + getHeight(root.left), 1 + getHeight(root.right));
    }
}
