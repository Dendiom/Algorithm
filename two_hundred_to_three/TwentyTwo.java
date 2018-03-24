package LeetCode.two_hundred_to_three;

public class TwentyTwo {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Time Limit Exceed.
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    /**
     * Approach from LeetCode.
     */
    public int countNodesTwo(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root, true);
        int rightDepth = getDepth(root, false);
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        } else {
            return 1 + countNodesTwo(root.left) + countNodesTwo(root.right);
        }
    }


    private int getDepth(TreeNode root, boolean left) {
        int depth = 1;
        if (left) {
            while (root.left != null) {
                depth++;
                root = root.left;
            }
        } else {
            while (root.right != null) {
                depth++;
                root = root.right;
            }
        }

        return depth;
    }

}
