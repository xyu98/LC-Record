public class Solution21 {
}

class Solution21_1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode tmp;
        if (l1.val > l2.val) {
            tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        ListNode head = l1, pre = l1, cur = l1;
        while (l2 != null && l1 != null) {
            while (l2 != null && l1 != null && l2.val == l1.val) {
                cur = l2;
                l2 = l2.next;
                if (l1.next != null) {
                    cur.next = l1.next;
                    l1.next = cur;
                    l1 = cur.next;
                    pre = cur;
                }
                else {
                    l1.next = cur;
                    l1 = null;
                    break;
                }
            }
            while (l2 != null && l1 != null && l2.val > l1.val) {
                pre = l1;
                l1 = l1.next;
                if (l1 == null) {
                    pre.next = l2;
                    break;
                }
            }
            while (l2 != null && l1 != null && l2.val < l1.val) {
                cur = l2;
                l2 = l2.next;
                pre.next = cur;
                cur.next = l1;
                pre = cur;
            }
        }
        return head;
    }
}