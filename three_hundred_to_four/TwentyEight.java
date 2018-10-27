package LeetCode.three_hundred_to_four;

public class TwentyEight {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next, evenTemp = even;
        ListNode temp = head.next.next;
        int count = 1;
        while (temp != null) {
            if (count % 2 != 0) { // odd
                odd.next = temp;
                odd = temp;
            } else {
                evenTemp.next = temp;
                evenTemp = temp;
            }

            temp = temp.next;
            count++;
        }

        odd.next = even;
        evenTemp.next = null;   // very important!!!
        return head;
    }

    public static ListNode generate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 0; i < nums.length ; i++) {
            ListNode node = new ListNode(nums[i]);
            temp.next = node;
            temp = node;
        }

        return head.next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = generate(new int[] {1, 2, 3, 4, 5});
        print(head);
        print(oddEvenList(head));
    }
}
