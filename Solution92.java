class Solution92_1 {
    ListNode nxt = null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return head;
        if (left == 1) return reverseFirstN(head, right);
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public ListNode reverseFirstN(ListNode head, int num) {
        if (num == 1) {
            nxt = head.next;
            return head;
        }
        ListNode last = reverseFirstN(head.next, num - 1);
        head.next.next = head;
        head.next = nxt;
        return last;
    }
}