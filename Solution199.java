import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution199 {
    public static void main(String[] args) {
        Solution199_1 s = new Solution199_1();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        System.out.println(s.rightSideView(t1));
    }
}

// 最关键的是找到每列的终点

// 解1：BFS
// 时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
// 空间复杂度：队列中元素的个数不超过 n 个，故渐进空间复杂度为 O(n)
class Solution199_1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if (root == null) return l;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {  // 注意判断是否为空用isEmpty();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                if (i == size - 1) l.add(q.peek().val);  // 或者换个思路，先放右边再放左边，直接取第一个即可
                TreeNode cur = q.poll();
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        return l;
    }
}