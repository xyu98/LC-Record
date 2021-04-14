import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution141 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        Solution141_3 s = new Solution141_3();
        System.out.println(s.hasCycle(node1));
    }
}

// 解1，理论上是比较优的解法
// 快慢指针法：时间复杂度O(N)，空间复杂度O(1)
// 【疑问】为什么解1的占用内存比解2大？？？
class Solution141_1 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            if (fast.next != null) fast = fast.next;
            if (fast == slow) return true; // 这里要比较两个ListNode而不是节点的value！！！
            slow = slow.next;
        }
        return false;
    }
}

// 解2 时间复杂度O(N),空间复杂度O(N)
// 开辟一个ListNode数组存放节点元素【同样注意不能只存放value】
class Solution141_2 {
    public boolean hasCycle(ListNode head) {
        ListNode[] listNode = new ListNode[10000];
        int count = 0;
        while (head != null) {
            for(int i = 0;i<=count;i++){
                if(listNode[i] == head)
                    return true;
            }
            listNode[count] = head;
            head = head.next;
            count++;
        }
        return false;
    }
}

// 解3，利用哈希表，最简单的思路
// 性能一般，时间空间复杂度都是O(N)
class Solution141_3 {
    public boolean hasCycle(ListNode head) {
        /*
        HashSet<ListNode> hs = new HashSet<>();
        while (head != null) {
            if (hs.contains(head)) return true;
            hs.add(head);
            if (head.next != null) head = head.next;
            else return false;
        }
        return false;

         */
        // 以上思路的改进版，利用HashSet不可重复的特性
        // HashSet的add()方法会返回一个boolean值，如果值已经存在返回false
        HashSet<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}