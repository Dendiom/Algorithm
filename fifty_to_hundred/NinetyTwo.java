package TestOne.fifty_to_hundred;

public class NinetyTwo {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // my solution: 4ms, but too long and confused.
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode pre = null;
        ListNode first = head;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        int index = 1;
        if (m != 1) {
            while (index != m - 1) {
                head = head.next;
                index++;
            }
            pre = head;
            head = head.next;
            first = head;
        }
        ListNode temp = null;
        while (n - m >= 0) {
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
            m++;
        }

        first.next = head;
        if (pre == null) {
            return temp;
        } else {
            pre.next = temp;
            return fakeHead.next;
        }
    }
}
