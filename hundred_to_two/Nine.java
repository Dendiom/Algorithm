package LeetCode.hundred_to_two;

public class Nine {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        return transfer(head, 0, length - 1);
    }

    public TreeNode transfer(ListNode head, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(head.val);
        }

        int mid = (start + end) / 2;
        int step = mid - start;
        ListNode temp = head;
        while (step > 0) {
            temp = temp.next;
            step--;
        }
        TreeNode root = new TreeNode(temp.val);
        root.left = transfer(head, start, mid - 1);
        root.right = transfer(temp.next, mid + 1, end);
        return root;
    }
}
