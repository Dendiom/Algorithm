package TestOne.hundred_to_two;


import java.util.Random;

public class FortyEight {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * helper methods, generate random List to test
     */

    private static ListNode[] generateList(int num, int bound, int listNum) {
        ListNode[] res = new ListNode[listNum];
        ListNode[] cur = new ListNode[listNum];
        for (int i = 0; i < listNum; i++) {
            res[i] = new ListNode(-1);
            cur[i] = res[i];
        }

        Random random = new Random(47);
        for (int i = 0; i < num; i++) {
            int val = random.nextInt(bound);
            for (int j = 0; j < listNum; j++) {
                ListNode node = new ListNode(val);
                cur[j].next = node;
                cur[j] = node;
            }
        }

        for (int i = 0; i < listNum; i++) {
            res[i] = res[i].next;
        }

        return res;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * insertion sort, worst -> o(n^2), insertion sort, time limit exceed
     */
    private static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fake = new ListNode(-1);
        ListNode max = head;
        fake.next = head;
        head = head.next;
        while (head != null) {
            ListNode next = head.next;
            if (head.val < max.val) {  // need to insert
                ListNode temp = fake;
                while (temp.next.val < head.val) {
                    temp = temp.next;
                }
                head.next = temp.next;
                temp.next = head;
                max.next = next; // avoid circle, very important
            } else {
                max = head;
            }
            head = next;
        }
        return fake.next;
    }

    /**
     * quick sort, exchange the val, not in-place
     */
    private static void quickSort(ListNode start, ListNode end) {
        if (start != end) {
            ListNode mid = quickSortHelper(start, end);
            quickSort(start, mid);
            quickSort(mid.next, end);
        }
    }

    private static ListNode quickSortHelper(ListNode start, ListNode end) {
        ListNode left = start, right = start;
        int key = start.val;
        while (right != end) {
            if (right.val < key) {
                left = left.next;
                exchangeVal(left, right);
            }
            right = right.next;
        }
        exchangeVal(start, left);
        return left; // all nodes before left is less than key,
    }

    private static void exchangeVal(ListNode one, ListNode two) {
        if (one != two) {
            int val = one.val;
            one.val = two.val;
            two.val = val;
        }
    }

    /**
     * merge sort.
     */

    private static ListNode mergeSort(ListNode start) {
        if (start.next == null) {
            return start;
        }
        ListNode fast = start, slow = start, pre = null; // pre is used to cut off the list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        ListNode left = mergeSort(start);
        ListNode right = mergeSort(slow);
        return merge(left ,right);
    }

    private static ListNode merge(ListNode one, ListNode two) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (one != null && two != null) {
            if (one.val < two.val) {
                ListNode temp = new ListNode(one.val);
                cur.next = temp;
                cur = temp;
                one = one.next;
            } else {
                ListNode temp = new ListNode(two.val);
                cur.next = temp;
                cur = temp;
                two = two.next;
            }
        }
        if (one != null) {
            cur.next = one;
        }
        if (two != null) {
            cur.next = two;
        }
        return pre.next;
    }


    public static void main(String[] args) {
        int num = 5000;
        System.out.printf("########## %d #########\n", num);
        ListNode[] heads = generateList(num, 5, 3);
        double before = System.currentTimeMillis();
        //printList(heads[0]);
        ListNode newHead = insertionSortList(heads[0]);
        //printList(newHead);
        System.out.println("insertion sort: " + (System.currentTimeMillis() - before));
        before = System.currentTimeMillis();
        //printList(heads[1]);
        quickSort(heads[1], null);
        //printList(heads[1]);
        System.out.println("quick sort: " + (System.currentTimeMillis() - before));
        before = System.currentTimeMillis();
        //printList(heads[1]);
        mergeSort(heads[2]);
        //printList(heads[1]);
        System.out.println("merge sort: " + (System.currentTimeMillis() - before));
    }
}
