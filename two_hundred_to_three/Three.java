package TestOne.two_hundred_to_three;


public class Three {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // use a fakeHead, remember to set preHead.next = null when you move ahead preHead.
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(0);
        ListNode preHead = fakeHead;
        if (head != null && head.val != val) {
            fakeHead.next = head;
            preHead = head;
            head = head.next;
            preHead.next = null;
        }

        while (head != null) {
            if (head.val != val) {
                preHead.next = head;
                preHead = head;
                head = head.next;
                preHead.next = null;
            } else {
                head = head.next;
            }

        }
        return fakeHead.next;
    }

    // recursive way from discuss
    public ListNode removeElementsRe(ListNode head, int val) {
        if (head == null)
            return null;
        head.next = removeElementsRe(head.next, val);
        return head.val == val ? head.next : head;
    }
}
