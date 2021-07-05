import java.util.LinkedList;
import java.util.List;

public class Solution203 {
    public static void main(String[] args) {
        Solution203_2 s = new Solution203_2();
        // 题目中只给了ListNode，不能用现成的LinkedList链表的方法
        // 遍历只能用结点及其next指针
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode head = new ListNode();
        head = s.removeElements(node1, 2);
        // 遍历输出
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }
}

// 第1次提交，执行用时: 1 ms（超过99.84%），内存消耗: 39.2 MB MB（超过85.31%）
class Solution203_1 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode tempHead = head; // 指向头节点
        ListNode prev = head;     // 当前操作对象的前一个节点
        if (tempHead == null) {
            return null;
        }

        // 头节点需要删除的情况
        while (tempHead.val == val) {
            if (tempHead.next != null) {
                tempHead = tempHead.next;
                prev = tempHead;
            }
            else {
                return null;
            }
        }

        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            }
            else {
                prev = prev.next;
            }
        }

        return tempHead;
    }
}

// 2021.7.5 review
class Solution203_2 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode pre, cur;
        while (head.val == val) {
            head = head.next;
            if (head == null) return null;
        }
        cur = head;
        pre = cur;
        while (cur != null) {
            if (cur.val == val) {
                cur = cur.next;
                pre.next = cur;
            }
            else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}