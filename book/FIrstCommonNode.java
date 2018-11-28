package LeetCode.book;

/**
 * 求两个链表的第一个公共节点
 */
public class FIrstCommonNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * a + b + c = c + b + a
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }

        return p1;
    }

}
