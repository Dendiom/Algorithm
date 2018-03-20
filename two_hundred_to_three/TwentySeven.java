package LeetCode.two_hundred_to_three;

import java.util.Stack;

public class TwentySeven {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }

            if (i == s.length() - 1 ||
                    (s.charAt(i) != ' ' && !Character.isDigit(s.charAt(i)))) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                num = 0;
                op = s.charAt(i);
            }
        }

        int ans = 0;
        for (int temp : stack) {
            ans += temp;
        }

        return ans;
    }

}
