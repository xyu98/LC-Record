import java.util.Stack;

public class Solution150 {
}

class Solution150_1 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" : stack.push(stack.pop() + stack.pop()); break;
                case "-" : stack.push(- stack.pop() + stack.pop()); break;
                case "*" : stack.push(stack.pop() * stack.pop()); break;
                case "/" : {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                    break;
                }
                default: stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}