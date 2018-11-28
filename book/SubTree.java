package LeetCode.book;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class SubTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 递归
     */
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        return rootSubTree(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    /**
     * 从根节点开始就相同
     */
    private boolean rootSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return rootSubTree(root1.left, root2.left) && rootSubTree(root1.right, root2.right);
    }
}
