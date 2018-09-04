package LeetCode.hundred_to_two;

import java.util.HashMap;
import java.util.List;

public class FortyTwo {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     *  fast & slow pointer
     *  fast: 2N, slow: N, N = start -> current
     *        2N - N = N = one loop
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        // double check for fast
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            return null;
        }

        ListNode start = head;
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }

        return start;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        two.next = head;
        System.out.println(detectCycle(head));
    }
}
