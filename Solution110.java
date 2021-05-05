public class Solution110 {
    public static void main(String[] args) {
        Solution110_1 s = new Solution110_1();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(2);
        t1.left = t2;
        t2.left = t3;
        t1.right = t4;
        t4.left = t5;
        System.out.println(s.isBalanced(t1));
    }
}

/*
class Solution110_1 {
    // 需要从子树获取的信息，左子树是否平衡，右子树是否平衡；左子树的高度，右子树的高度
    int leftHeight = 0;
    int rightHeight = 0;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        else return deliver(root, leftHeight, rightHeight);
    }

    public boolean deliver(TreeNode node, int LeftSize, int RightSize) {
        if (node.left != null) {
            leftHeight = leftHeight + 1;
            deliver(node.left, leftHeight, rightHeight);
        }
        if (node.right != null) {
            rightHeight = rightHeight + 1;
            deliver(node.right, leftHeight, rightHeight);
        }
        if (Math.abs(leftHeight - rightHeight) < 2) return true;
        else return false;
    }
}
 */

class Solution110_1 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 需要从子树获取的信息，左子树是否平衡，右子树是否平衡；左子树和右子树高度差的绝对值
        // 用高度=-1代替了boolean变量isBalance
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // 当前节点需要提供的信息
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1; // 这一步很关键！！！
        }
    }
}