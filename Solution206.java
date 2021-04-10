import java.util.LinkedList;

public class Solution206 {
    public static void main(String[] args) {
        Solution206_1 s = new Solution206_1();
        // 题目中只给了ListNode，不能用现成的LinkedList链表的方法
        // 遍历只能用结点及其next指针
        // LinkedList<ListNode> l1 = new LinkedList<>();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        //ListNode iter = node1; // 用于遍历
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        /*l1.add(node1);
        l1.add(node2);
        l1.add(node3);
        l1.add(node4);*/
        ListNode head = new ListNode();
        head = s.reverseList(node1);
        // 遍历输出
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }
}

// 第1次提交，执行用时: 0 ms（超过100%），内存消耗: 38.2 MB MB（超过61.74%）
class Solution206_1 {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = head;
        ListNode nxt = head;

        if (head == null || head.next == null) {
            return head;
        }

        current = head.next;
        head.next = null;

        while (current.next != null) {
            nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
        }
        head = current;
        head.next = prev;
        return head;
    }
}
