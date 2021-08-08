import java.util.Arrays;
import java.util.Stack;

public class Solution1047 {
}

class Solution1047_1 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == stack.peek()) stack.pop();
            else stack.push(s.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        for (int i = stack.size() - 1; i >= 0; i--) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}