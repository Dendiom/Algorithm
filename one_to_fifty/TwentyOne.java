package TestOne.one_to_fifty;

import java.awt.Label;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

public class TwentyOne {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	// my own way, use extra space, 16ms
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {  
		ListNode head = new ListNode(0);
		ListNode current = head;
		while(l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				current.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			current = current.next;
		}
		if (l1 != null) {
			current.next = l1;
		}
		if (l2 != null) {
			current.next = l2;
		}
		return head.next;
	}
	
	// recursive, maybe stack overflow
	public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {  
		if (l1 == null) {
			return l2;
		}
		
		if (l2 == null) {
			return l1;
		}
		
		if (l1.val < l2.val) {
			l1.next =  mergeTwoLists(l1.next, l2);
			return l1;
		}
		
		l2.next = mergeTwoLists(l1, l2.next);
		return l2;
		
	}
}
