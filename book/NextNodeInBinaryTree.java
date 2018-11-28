package LeetCode.book;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class NextNodeInBinaryTree {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        // 如果存在右节点，则必是右节点的最左节点
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        // 不存在右节点，向上找第一个左父节点
        TreeLinkNode node = pNode.next;
        while (node != null) {
            if (node.left == pNode) {
                return node;
            }

            pNode = node;
            node = node.next;
        }

        return null;
    }
}
