public class Solution24 {
}

class Solution24_1 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head; // 建立伪头
        ListNode pre = dummyHead;
        ListNode nxt = head;
        while (head != null && head.next != null) {
            nxt = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = nxt;
            pre = head;
            head = nxt;
        }
        return dummyHead.next;
    }
}