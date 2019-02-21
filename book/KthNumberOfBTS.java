package LeetCode.book;

/**
 * 二叉搜索树中第k个数
 */
public class KthNumberOfBTS {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private int number;
    private TreeNode result;

    /**
     * 中序遍历即可
     */
    TreeNode kthNodeInBST(TreeNode pRoot, int k) {
        number = k;
        find(pRoot);
        return result;
    }

    private void find(TreeNode node) {
        if (node == null) {
            return;
        }

        find(node.left);
        if (number == 1) {
            if (result == null) {  // 避免结果被覆盖
                result = node;
            }

            return;
        } else {
            number--;
        }

        find(node.right);
    }
}
