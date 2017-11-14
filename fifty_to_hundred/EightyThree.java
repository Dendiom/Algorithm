package TestOne.fifty_to_hundred;

public class EightyThree {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {  // 1 ms, use too mush space
        if (head == null)
            return null;
        ListNode ans = new ListNode(head.val);
        ListNode currentHead = ans;
        while(head.next != null) {
            ListNode nextNode = head.next;
            if (head.val != nextNode.val) {
                ListNode newNode = new ListNode(nextNode.val);
                currentHead.next = newNode;
                currentHead = newNode;
            }
            head = nextNode;
        }
        return ans;
    }

    public ListNode deleteWithoutNew(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode pos = head;
        while(pos.next != null){
            if(pos.val == pos.next.val){
                pos.next = pos.next.next;   // pos hasn't changed until val1 != val2
            }
            else{
                pos = pos.next;
            }
        }

        return head;
    }
}

