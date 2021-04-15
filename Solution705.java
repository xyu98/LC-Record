public class Solution705 {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        boolean a1 = myHashSet.contains(1); // 返回 True
        boolean a2 = myHashSet.contains(3); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        boolean a3 = myHashSet.contains(2); // 返回 True
        myHashSet.remove(2);   // set = [1]
        boolean a4 = myHashSet.contains(2); // 返回 False ，（已移除）
        System.out.println(a1 + " " + a2 + " " + a3 + " " + a4);
    }
}

// 题目不严谨
class MyHashSet {
    boolean[] arr = new boolean[1000001];
    public MyHashSet() {

    }

    public void add(int key) {
        arr[key] = true;
    }

    public void remove(int key) {
        arr[key] = false;
    }

    public boolean contains(int key) {
        return arr[key];
    }
}