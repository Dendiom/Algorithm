package TestOne.one_to_fifty;


public class TwentyFour {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        ListNode pre = fakeHead;
        ListNode copy = null;
        while(head != null && head.next != null) {
            copy = head;
            head = head.next.next;
            pre.next = copy.next;
            pre.next.next = copy;
            pre = copy;
        }
        if (head != null) { // head.next == null
            pre.next = head;
        }
        return fakeHead.next;
    }
}
