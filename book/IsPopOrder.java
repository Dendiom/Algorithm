package LeetCode.book;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 */
public class IsPopOrder {

    /**
     * 使用一个栈来模拟操作
     */
    public boolean isPopOrder(int[] pushA,int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }

        int length = pushA.length;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < length; i++) {
            stack.push(pushA[i]);
            if (pushA[i] == popA[index]) {
                stack.pop();
                index++;
            }
        }

        while (!stack.isEmpty()) {
            if (index >= length || stack.pop() != popA[index++]) {
                return false;
            }
        }

        return true;
    }
}
