public class Solution230 {
    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(3);
        TreeNode tn2 = new TreeNode(1);
        TreeNode tn3 = new TreeNode(4);
        TreeNode tn4 = new TreeNode(2);
        tn1.left = tn2;
        tn1.right = tn3;
        tn2.right = tn4;
        Solution230_1 s = new Solution230_1();
        System.out.println(s.kthSmallest(tn1,1));
    }
}

// 时间O(N)，空间O(1)。空间已最优
// 时间还可以优化成O(log2(N))，但是在lc中无法实现（TreeNode缺少一个字段）
class Solution230_1 {
    int cnt = 0;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        if (root.left != null) kthSmallest(root.left, k);
        cnt++;
        if (cnt == k) res = root.val;
        if (root.right != null) kthSmallest(root.right, k);
        return res;
    }
}