package LeetCode.hundred_to_two;

public class Six {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return construct(inorder, postorder, 0, inorder.length - 1, inorder.length - 1);
    }

    public TreeNode construct(int[] in, int[] post, int start, int end, int rootIndex) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(in[start]);
        }

        int rootVal = post[rootIndex];
        TreeNode root = new TreeNode(rootVal);
        int index = start;
        for(; index <= end; index++) {
            if (in[index] == rootVal) {
                break;
            }
        }

        root.left = construct(in, post, start, index - 1, rootIndex - 1 - end + index);
        root.right = construct(in ,post, index + 1, end, rootIndex - 1);
        return root;
    }
}
