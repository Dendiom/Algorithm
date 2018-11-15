package LeetCode.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 输入链表的第一个节点，从尾到头反过来打印出每个结点的值
 */
public class PrintListReverse {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归法
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (listNode == null) {
            return ans;
        }

        recursive(ans, listNode);
        return ans;
    }

    public void recursive(ArrayList<Integer> list, ListNode node) {
        if (node.next != null) {
            recursive(list, node.next);
        }

        list.add(node.val);
    }


    /**
     * 使用一个栈
     */
    public ArrayList<Integer> printListFromTailToHeadTwo(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (listNode == null) {
            return ans;
        }

        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        return ans;
    }
}
