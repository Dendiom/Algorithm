package LeetCode.book;

/**
 * 反转链表
 */
public class ReverseList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next; // 先保存
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }

        return dummy.next;
    }
}
