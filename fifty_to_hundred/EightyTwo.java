package TestOne.fifty_to_hundred;


public class EightyTwo {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // my solution, 2 ms
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode pre = fakeHead;
        int currentVal = 0;

        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {        // to init currentVal correctly!!!
            currentVal = head.val;
            head = head.next;
        } else {
            currentVal = head.val;
            pre.next = head;
            pre = head;
            head = head.next;
            pre.next = null;
        }

        while (head.next != null) {
            if (head.val != currentVal && head.next.val != head.val) {
                currentVal = head.val;
                pre.next = head;
                pre = head;
                head = head.next;
                pre.next = null;                // important
            } else {
                currentVal = head.val;
                head = head.next;
            }
        }


        if (head.val != currentVal) {
            pre.next = head;
        }

        return fakeHead.next;
    }

    // 1ms solution
    public ListNode deleteDuplicatesBetter(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, slow = head, fast = head;
        while (fast != null) {
            while (fast != null && fast.val == slow.val)
                fast = fast.next;
            if (slow.next != fast) {
                pre.next = fast;
            } else {
                pre = pre.next;
            }
            slow = fast;
        }
        return dummy.next;
    }
}
