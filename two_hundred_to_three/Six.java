package TestOne.two_hundred_to_three;

import javax.swing.*;

public class Six {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // solution1: head insertion method
    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(-1);
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = pre.next;
            pre.next = temp;
            head = head.next;
        }

        return  pre.next;
    }

    // solution2: use two pointer, pre and cur, let head.next = cur
    public ListNode reverseListTwo(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode pre = head;
        head = head.next;
        while (head != null) {
            pre.next = head.next;
            head.next = fakeHead.next;
            fakeHead.next = head;
            head = pre.next;
        }

        return fakeHead.next;
    }

    // solution3: from forum
    public ListNode reverseListThree(ListNode head) {
        ListNode prev = null;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    // solution4: recursive
    public ListNode reverseListFour(ListNode head) {
       return reverse(head, null);
    }

    private ListNode reverse(ListNode cur, ListNode head) {
        if (cur == null) {
            return head;
        }
        ListNode next = cur.next;
        cur.next = head;
        return reverse(next, cur);
    }
}
