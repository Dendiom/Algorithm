package LeetCode.book;

/**
 * 链表中倒数第 K 个结点
 */
public class FindKthToTail {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * 双指针法，一个指针先移动k步，然后两个指针一起移动，第一个指针到达尾部后，第二个指针为所求值
     * 注意可能k超过了范围，即参数校验
     */
    public ListNode findKthToTail(ListNode head,int k) {
        if (head == null) {
            return null;
        }

        ListNode pointer1 = head, pointer2 = head;

        for (int i = 0; i < k; i++) {
            if (pointer1 == null) {
                return null;
            }

            pointer1 = pointer1.next;
        }

        while (pointer1 != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer2;
    }

}
