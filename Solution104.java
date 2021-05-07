public class Solution104 {
    public static void main(String[] args) {
        Solution104_1 s = new Solution104_1();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        System.out.println(s.maxDepth(t1));
    }
}

// 解1 DFS（递归），自顶向下
// 时间O(n),n为节点个数；空间O(N)
class Solution104_1 {
    int res;
    public int maxDepth(TreeNode root) {
        int height = 1;
        if (root == null) return 0;
        dfsTopDown(root, height);
        return res;
    }

    public void dfsTopDown(TreeNode node, int height) {
        res = Math.max(res, height);
        if (node.left != null) {
            dfsTopDown(node.left, height + 1);
        }
        if (node.right != null) {
            dfsTopDown(node.right, height + 1);
        }
    }
}

// 解2，也是递归，思路变成自底向上，更简洁
// 时间O(n),n为节点个数；空间O(height)
class Solution104_2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1; //自下而上
        }
    }
}

