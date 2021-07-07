import java.time.chrono.MinguoDate;

public class Solution142 {
}

public class Solution142_1 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        ListNode index = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                index = fast;
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;
        else {
            while (index != head) {
                index = index.next;
                head = head.next;
            }
            return index;
        }
    }
}