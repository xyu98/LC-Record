import java.util.ArrayList;

public class Solution622 {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(4);
        System.out.println(circularQueue.enQueue(0));
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.enQueue(0));
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.Front());
    }
}

// 直接用数组实现比较方便
class MyCircularQueue {
    private ArrayList<Integer> arr;
    private int front = 0;
    private int rear = 0;
    private final int len;

    public MyCircularQueue(int len) {
        this.arr = new ArrayList<>(len + 1);
        this.len = len + 1;
    }

    public boolean enQueue(int value) {
        if (this.isFull()) return false;
        arr.add(rear, value);
        rear = (rear + 1) % len;
        return true;
    }

    public boolean deQueue() {
        if (this.isEmpty()) return false;
        front = (front + 1) % len;
        return true;
    }

    public int Front() {
        if (this.isEmpty()) return -1;
        return arr.get(front);
    }

    public int Rear() {
        if (this.isEmpty()) return -1;
        if (rear - 1 < 0) return arr.get(len - 1);
        else return arr.get(rear - 1);
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return front == ((rear + 1) % len);
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

/*
public class MyCircularQueue {
    private int[] data;
    private int front;
    private int tail;

    public MyCircularQueue(int k) {
        data = new int[k + 1];
        front = 0;
        tail = 0;
    }

    public boolean enQueue(int value) {
        if ((tail + 1) % data.length == front) {
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % data.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % data.length;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        if (tail == 0) {
            return data[data.length - 1];
        }
        return data[(tail - 1)];
    }

    public boolean isEmpty() {
        return front == tail;
    }

    public boolean isFull() {
        return ((tail + 1) % data.length) == front;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());

    }
}
 */