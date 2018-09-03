package LeetCode.hundred_to_two;

public class Five {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, preorder.length - 1, 0);
    }

    public TreeNode construct(int[] pre, int[] in, int start, int end, int preStart) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(in[start]);
        }

        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        int index = start;

        for (; index <= end; index++) {
            if (in[index] == rootVal) {
                break;
            }
        }

        // preStart is most confused here.
        root.left = construct(pre, in, start, index - 1, preStart + 1);
        root.right = construct(pre, in, index + 1, end, preStart + 1 + index - start);
        return root;
    }
}
