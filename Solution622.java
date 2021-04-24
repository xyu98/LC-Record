import java.util.ArrayList;

public class Solution622 {
    public static void main(String[] args) {
        MyCircularQueue q = new MyCircularQueue(5);

    }
}

class MyCircularQueue {
    ArrayList<Integer> arr;
    int front = 0;
    int rear = 0;
    int len;

    public MyCircularQueue(int len) {
        this.arr = new ArrayList<>(len);
    }

    public boolean enQueue(int value) {
        if (this.isFull()) return false;

    }

    public boolean deQueue() {

    }

    public int Front() {

    }

    public int Rear() {

    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return front == (rear + 1) % len;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */