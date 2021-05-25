package _crackingthecodinginterview.chapter04;

public class ListNode {
    int val;        // 当前节点的内容
    ListNode next;  // 下一个节点的指针
    ListNode() {}   // 无参构造方法
    ListNode(int val) { this.val = val; }  // 构造方法
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }  // 构造方法

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}