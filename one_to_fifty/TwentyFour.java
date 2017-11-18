package TestOne.one_to_fifty;

public class TwentyFour {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		ListNode copy = null;
		while (head != null && head.next != null) {
			copy = head;
			head = head.next.next;
			pre.next = copy.next;
			pre.next.next = copy;
			pre = copy;
			pre.next = null;      // very important, or will be a circle
		}
		if (head != null) { // head.next == null
			pre.next = head;
		}
		return fakeHead.next;
	}

	public static void main(String[] args) {
		ListNode nodeOne = new ListNode(0);
		ListNode nodeTwo = new ListNode(1);
		ListNode nodeThree = new ListNode(2);
		nodeOne.next = nodeTwo;
		//nodeTwo.next = nodeThree;
		ListNode s = swapPairs(nodeOne);
		while (s != null) {
			System.out.println(s.val);
			s = s.next;
		}
	}
}
