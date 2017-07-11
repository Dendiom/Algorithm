package TestOne.one_to_fifty;



import java.util.Stack;

public class Twenty {


    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c == '(') {
                stack.push(')');
                continue;
            }
            if(c == '{') {
                stack.push('}');
                continue;
            }
            if(c == '[') {
                stack.push(']');
                continue;
            }
            if(stack.isEmpty() || c!=stack.pop())
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(isValid("{)}"));
        System.out.println(isValid("{}{"));
        System.out.println(isValid("{}(])"));

    }
}
