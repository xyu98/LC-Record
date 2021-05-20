public class Solution226 {
    public static void main(String[] args) {
        Solution226_2 s = new Solution226_2();
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
    }
}

class Solution226_1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        inverseNode(root.left, root.right);
        return root;
    }
    // 为什么这样反不过来？因为调用方法时，只传了左右子树，操作的是复制后的值，原二叉树没有动
    public void inverseNode(TreeNode tn1, TreeNode tn2) {
        if (tn1 == null && tn2 == null) return;
        TreeNode temp = tn1;
        tn1 = tn2;
        tn2 = temp;
        inverseNode(tn1.left, tn1.right);
        inverseNode(tn2.left, tn2.right);
    }
}

class Solution226_2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        // 前序，自顶向下
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

//
class Solution226_3 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        if (left != null && right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        } else if (root.left == null) {
            root.left = root.right;
            root.right = null;
        } else {
            root.right = root.left;
            root.left = null;
        }
        return root;
    }
}