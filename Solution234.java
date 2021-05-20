import java.util.Stack;

public class Solution234 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution234_2 s = new Solution234_2();
        System.out.println(s.isPalindrome(l1));
    }
}

// 最简单的思路，时间O(N)，空间O(N)
class Solution234_1 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        Stack<Integer> s = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            s.push(cur.val);
            cur = cur.next;
        }
        int i = 0, sz = s.size();
        while (i <  sz/ 2) {
            if (head.val != s.pop()) return false;
            i++;
            head = head.next;
        }
        return true;
    }
}

// 快慢指针法，不使用额外的空间
// 快指针的速度是慢指针的两倍，快指针走到最后，慢指针走到中间
// 将慢指针部分反转
class Solution234_2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head, cur;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1, l2 = slow.next;
        if (fast.next != null) {
            //fast = fast.next;
            l1 = reverseList(head, l2);
        }
        else l1 = reverseList(head, slow);
        while (l1 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head, ListNode tail) {
        ListNode pre = null, nxt = head;
        if (head == null || head.next == null) return head;
        while (head != tail) {
            nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }
}