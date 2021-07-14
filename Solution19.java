public class Solution19 {
}

class Solution19_1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = dummyHead, fast = dummyHead, pre = slow;
        for (int i = 0; i < n; i++) fast = fast.next;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        } // 此时slow就是需要删掉的节点
        pre.next = slow.next;
        return dummyHead.next;
    }
}