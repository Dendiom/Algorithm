package LeetCode.book;

/**
 * 合并两个排序的链表
 */
public class MergeSortedLinkedList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 非递归
    public ListNode mergeTwo(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                cur = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = list2;
                list2 = list2.next;
            }
        }

        if (list1 == null) {
            cur.next = list2;
        }

        if (list2 == null) {
            cur.next = list1;
        }

        return dummy.next;
    }

    // 递归
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        }

        list2.next = merge(list1, list2.next);
        return list2;
    }

}
