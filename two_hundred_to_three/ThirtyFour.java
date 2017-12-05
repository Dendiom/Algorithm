package TestOne.two_hundred_to_three;

import java.util.Stack;

public class ThirtyFour {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // solution 1: use a stack to restore value, o(n) space. 5ms
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            stack.push(slow.val);
            slow = slow.next;
        }
        slow = fast == null ? slow : slow.next;
        while (slow != null) {
            if (slow.val != stack.pop())
                return false;
            slow = slow.next;
        }

        return true;
    }

    // solution 2: reverse half the list and compare it. only o(1) space
    public boolean isPalindromeTwo(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = fast == null ? slow : slow.next;

        ListNode preHead = new ListNode(-1);
        while (slow != null) {
            ListNode temp = new ListNode(slow.val);
            temp.next = preHead.next;
            preHead.next = temp;
            slow = slow.next;
        }

        preHead = preHead.next;
        while (preHead != null) {
            if (head.val != preHead.val)
                return false;
            preHead = preHead.next;
            head = head.next;
        }

        return true;
    }
}
