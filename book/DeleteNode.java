package LeetCode.book;


/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        if (pHead.val == pHead.next.val) { // 从第一个不同节点开始递归
            int val = pHead.val;
            while (pHead != null && pHead.val == val) {
                pHead = pHead.next;
            }
            return deleteDuplication(pHead);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    /**
     * 如果保留重复节点
     */
    public ListNode deleteDuplicationTwo(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode node = pHead;
        while (node.next != null) {
            if (node.next.val == node.val) { // 删除下一个节点,但是不移动pHead
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return pHead;
    }

}
