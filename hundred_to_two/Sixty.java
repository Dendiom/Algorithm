package TestOne.hundred_to_two;


public class Sixty {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // solution 1: get the length first
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        while(lengthA > lengthB) {
            lengthA--;
            headA = headA.next;
        }

        while (lengthA < lengthB) {
            lengthB--;
            headB = headB.next;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;

    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // solution 2:use two iterations to do that.
    // In the first iteration, we will reset the pointer of one linkedlist to the head of another linkedlist after it reaches the tail node.
    // In the second iteration, we will move two pointers until they points to the same node.
    // from discuss
    public ListNode getIntersectionNodeTwo (ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB: a.next;
            b = b == null ? headA: b.next;
        }

        return a;
    }
}
