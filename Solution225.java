import java.util.LinkedList;
import java.util.Queue;

public class Solution225 {
}

class MyStack {
    private Queue<Integer> q1; // 元素存放
    private Queue<Integer> q2; // 辅助
    // 可以只用q1来实现存放，q2只辅助作用；也可以q1作为输入，q2作为输出

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (q1.isEmpty()) {
            q1.add(x);
            return;
        }
        while (!q1.isEmpty()) q2.add(q1.poll());
        q1.add(x);
        while (!q2.isEmpty()) q1.add(q2.poll());
        /*// 另一种写法，思路是一样的，就是使队列q2始终为空
        q2.offer(x);
        // 将q1队列中元素全部转给q2队列
        while(!q1.isEmpty()) q2.offer(q1.poll());
        // 交换q1和q2,使得q2队列没有在push()的时候始终为空队列，也就是起辅助作用
        Queue temp = q1;
        q1 = q2;
        q2 = temp;*/
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */