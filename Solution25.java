public class Solution25 {
}

class Solution25_1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) return head;
            tail = tail.next;
        }
        ListNode newHead = reverseListBetweenTwo(head, tail);//只考虑这个函数的功能，head和tail在里面怎么变不影响外面！
        // 难点是怎么把各段连起来
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    // 反转[a,b-1]范围内的节点
    public ListNode reverseListBetweenTwo(ListNode a, ListNode b) {
        ListNode pre = null, nxt = a;
        if (a == null) return a;
        while (a != b) {
            nxt = a.next;
            a.next = pre;
            pre = a;
            a = nxt;
        }
        return pre;
    }
}