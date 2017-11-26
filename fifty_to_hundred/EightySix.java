package TestOne.fifty_to_hundred;

public class EightySix {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // my solution: use two list to record different partition, then merge them.
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode more = new ListNode(-1);
        ListNode lessTemp = less;
        ListNode moreTemp = more;

        while (head != null) {
            if (head.val < x) {
                lessTemp.next = head;
                lessTemp = head;
                head = head.next;
                lessTemp.next = null;  // a little redundant
            } else {
                moreTemp.next = head;
                moreTemp = head;
                head = head.next;
                moreTemp.next = null;
            }
        }

        /**
         *  this way is shorter
         */
//        while (head != null) {
//            if (head.val < x) {
//                lessTemp.next = head;
//                lessTemp = head;
//            } else {
//                moreTemp.next = head;
//                moreTemp = head;
//            }
//            head = head.next;
//        }
//        moreTemp.next = null;        // don't need to set null every time!

        lessTemp.next = more.next;
        return less.next;


    }
}
