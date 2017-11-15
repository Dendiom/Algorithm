package TestOne.one_to_fifty;


import java.util.ArrayList;
import java.util.List;

public class Nineteen {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // solution 1: go through the list twice. The first time is aiming to get the length.

    // solution 2: use an extra list to save the passed node.  15 ms
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodeArr = new ArrayList<>();
        nodeArr.add(head);
        while (head.next != null) {
            head = head.next;
            nodeArr.add(head);
        }
        if (nodeArr.size() - n == 0) // remove the first one
            return nodeArr.size() == 1 ? null : nodeArr.get(1);
        if (n == 1) { // remove the last one
            nodeArr.get(nodeArr.size() - n - 1).next = null;
        } else {
            nodeArr.get(nodeArr.size() - n - 1).next = nodeArr.get(nodeArr.size() - n + 1);
        }
        return nodeArr.get(0);
    }

    // solution 3: better way
    public ListNode removeNthFromEndTwo(ListNode head, int n) {
        ListNode h1 = head, h2 = head;
        while (n-- > 0)
            h2 = h2.next;      // h2 is the (n+1)th node
        if (h2 == null)
            return head.next;  // The head need to be removed, do it.
        h2 = h2.next;

        while (h2 != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        h1.next = h1.next.next;   // the one after the h1 need to be removed
        return head;
    }
}
