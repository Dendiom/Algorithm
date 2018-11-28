package LeetCode.book;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
 */
public class EntryNodeOfLoop {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 双指针法，经典问题
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead, fast = pHead;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {  // 有环
                ListNode again = pHead;
                while (again != slow) {
                    again = again.next;
                    slow = slow.next;
                }
                return again;
            }
        }

        return null;
    }
}
