package LeetCode.book;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class MirrorTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 简单的交换，然后递归即可
     */
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }
}
