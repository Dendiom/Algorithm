package LeetCode.book;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class MinStack {

    /**
     * 使用两个栈，其中一个栈存储当前的最小值
     */

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.empty()) {
            minStack.push(node);
        } else {
            minStack.push(Math.min(min(), node));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
