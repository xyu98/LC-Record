import java.util.LinkedList;
import java.util.Stack;

public class Solution20 {
    public static void main(String[] args) {
        Solution20_1 s1 = new Solution20_1();
        String s = "]";
        System.out.println(s1.isValid(s));
    }
}

// 第1次提交，执行用时: 3 ms（超过25.33%），内存消耗: 36.5 MB（超过69.41%）
class Solution20_1 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            else if ((!stack.isEmpty()) && stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
            }
            else if ((!stack.isEmpty()) && stack.peek() == '[' && s.charAt(i) == ']') {
                stack.pop();
            }
            else if ((!stack.isEmpty()) && stack.peek() == '{' && s.charAt(i) == '}') {
                stack.pop();
            }
            else return false;
        }
        return stack.isEmpty();
    }
}

// 第2次提交：执行用时: 2 ms（超过76.65%），内存消耗: 36.6 MB（超过61.17%）
// 这个和上面算法是一样的，改进了if-else分支的结构
class Solution20_2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            else if (!stack.isEmpty()) {
                if (stack.peek() == '(' && s.charAt(i) == ')') {
                    stack.pop();
                }
                else if (stack.peek() == '[' && s.charAt(i) == ']') {
                    stack.pop();
                }
                else if (stack.peek() == '{' && s.charAt(i) == '}') {
                    stack.pop();
                }
                else return false;
            }
            else return false;
        }
        return stack.isEmpty();
    }
}