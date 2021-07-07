import java.util.LinkedList;
import java.util.List;

public class Solution206 {
    public static void main(String[] args) {
        Solution206_revise1 s = new Solution206_revise1();
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
        ListNode current = head;  // 【注】current完全可以优化掉（就是head）
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

// 解法2：空间复杂度最优（只需要两个ListNode变量）
class Solution206_2 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {  // 现在这里判断了空链表的情况
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

// 解3：递归 时间O(N)空间O(N)
class Solution206_3 {
    public ListNode reverseList(ListNode head) {
        // 终止条件
        if (head == null && head.next == null) return head;
        ListNode p = reverseList(head.next); // 在这里执行到最底一层嵌套，然后开始返回
        head.next.next = head;
        head.next = null;
        return p;
    }
}

// 2021.04.12 revise
class Solution206_revise1 {
    public ListNode reverseList(ListNode head) {
        ListNode prv = head;
        ListNode nxt = head;  // 特别注意这里,不能直接写nxt = head.next; 因为不确定是否有下一个

        if (head == null || head.next == null) {
            return head;
        }
        nxt = head.next;
        head.next = null;
        while (nxt.next != null) {
            head = nxt;
            nxt = nxt.next;
            head.next = prv;
            prv = head;
        }
        nxt.next = head;
        return nxt;
    }
}

// 2021.07.05 revise 常规法
class Solution206_revise2 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, nxt;
        while (head != null) {
            nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }
}
// 递归（不熟）
class Solution206_revise3 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}