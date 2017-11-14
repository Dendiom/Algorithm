package TestOne.hundred_to_two;



public class fortyOne {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // use two pointers. One goes step by step, the other goes two steps each time.If there is a cycle, they'll meet.
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode oneStep = head;
        ListNode twoStep = head;
        while(twoStep.next != null && twoStep.next.next != null) {
            if (oneStep.next == twoStep.next.next) {
                return true;
            }
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        return false;
    }

    // make every node you visited point to head, if node.next == head , there must be a cycle
    public boolean hasCycleTwo(ListNode head) {
        ListNode current = head;
        ListNode pre = head;
        while(current != null && current.next != null) {
            if (current.next == head) {
                return true;
            }
            current = current.next;
            pre.next = head;
            pre = current;
        }
        return false;
    }
}
