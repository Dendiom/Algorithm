package LeetCode.book;

/**
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class ConstructBInaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 前序遍历第一个值为中心点，找到其在中序遍历中的位置，再对其左右节点分别进行递归
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return construct(pre, in, 0, 0, in.length - 1);
    }

    public TreeNode construct(int[] pre, int[] in, int pStart, int iStart, int iEnd) {
        if (iStart > iEnd) {
            return null;
        }

        if (iStart == iEnd) {
            return new TreeNode(in[iStart]);
        }

        int rootVal = pre[pStart];
        TreeNode root = new TreeNode(rootVal);
        int index = iStart;

        for (; index <= iEnd; index++) {
            if (in[index] == rootVal) {
                break;
            }
        }

        // 递归
        root.left = construct(pre, in, pStart + 1, iStart, index - 1);
        root.right = construct(pre, in, pStart + index - iStart + 1, index + 1, iEnd);
        return root;
    }
}
