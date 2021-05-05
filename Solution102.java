import java.util.*;

public class Solution102 {
    public static void main(String[] args) {
        Solution102_2 s = new Solution102_2();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        System.out.println(s.levelOrder(t1));
    }
}

// 解1，reference
// 时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
// 空间复杂度：队列中元素的个数不超过 n 个，故渐进空间复杂度为 O(n)
class Solution102_1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        // 用一个队列辅助，当前层节点入列，前一层出列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>(); // 存储每层的节点
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}

// 解2，复现上面的解法
class Solution102_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> levelValue = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();
                levelValue.add(current.val);
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            res.add(levelValue);
        }
        return res;
    }
}
