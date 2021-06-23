public class Solution337 {
}

class Solution337_1 {
    public int rob(TreeNode root) {
        int[] result = robTree(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robTree(TreeNode root) {
        if (root == null) return new int[] {0,0};
        int[] valLeft = robTree(root.left);
        int[] valRight = robTree(root.right);
        // 当前节点的逻辑
        // 1. 抢当前节点,左右节点都不能抢
        int val1 = valLeft[0] + valRight[0] + root.val;
        // 2. 不抢当前节点,左右节点都可以考虑抢（非必须抢,因此均取最大值即可）
        int val2 = Math.max(valLeft[0], valLeft[1]) + Math.max(valRight[0], valRight[1]);
        return new int[] {val2, val1};
    }
}