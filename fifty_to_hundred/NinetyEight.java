package LeetCode.fifty_to_hundred;


public class NinetyEight {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Recursive approach.
     */
    private boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValidHelper(root, false, false, root.val, root.val);
    }

    /**
     * @param root  current node.
     * @param left  current node is left node of one of previous nodes.
     * @param right current node is right node of one of previous nodes.
     * @param max  current val needs to be less than max.
     * @param min  current val needs to be more than min.
     */
    private boolean isValidHelper(TreeNode root, boolean left, boolean right, int max, int min) {
        if (root == null) {
            return true;
        }

        if (root.left != null) {
            if (root.left.val >= max) {
                return false;
            }

            if (right && root.left.val <= min) {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.val <= min) {
                return false;
            }

            if (left && root.right.val >= max) {
                return false;
            }
        }

        return isValidHelper(root.left, true, right, root.val, min) && isValidHelper(root.right, left, true, max, root.val);
    }
}
