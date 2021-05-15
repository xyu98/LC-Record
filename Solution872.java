import java.util.LinkedList;
import java.util.List;

public class Solution872 {
    public static void main(String[] args) {
        Solution872_1 s = new Solution872_1();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t4.left = t5;
        t4.right = t6;
        System.out.println(s.leafSimilar(t1,t4));
    }
}

// 解1，用两个数组递归
class Solution872_1 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new LinkedList<>();
        List<Integer> leaf2 = new LinkedList<>();
        findLeaves(root1,leaf1);
        findLeaves(root2,leaf2);

        // 这一段可优化
        /*if (leaf1.size() != leaf2.size()) return false;
        for (int i = 0; i < leaf1.size(); i++) {
            if (!leaf1.get(i).equals(leaf2.get(i))) return false;
        }
        return true;
        */

        return leaf1.equals(leaf2);
    }
    public void findLeaves(TreeNode root, List<Integer> leaf) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaf.add(root.val);
            return;
        }
        if (root.left != null) findLeaves(root.left, leaf);
        if (root.right != null) findLeaves(root.right, leaf);
    }
}