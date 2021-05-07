public class Solution98 {
    public static void main(String[] args) {
        Solution98_1 s = new Solution98_1();
        /*TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;*/
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.println(s.isValidBST(t1));
    }
}

class Solution98_1 {
    public boolean isValidBST(TreeNode root) {
        return recurse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // min是左子树上界，当前val要比它大；max是右子树下界，当前val要比它小
    boolean recurse(TreeNode node, long min, long max) {
        if (node == null)
            return true;
        if (node.val <= min || node.val >= max)
            return false;
        return recurse(node.left, min, node.val)
                && recurse(node.right, node.val, max);
    }
}



/*
class Solution98_1 {
    int leftMax;
    int rightMin;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return dfsValidBST(root);
    }

    public boolean dfsValidBST(TreeNode root) {
        if (root.left == null && root.right == null)  {
            leftMax = root.val;
            rightMin = root.val;
            return true;
        }
        if (root.left == null) {
            rightMin = Math.min(root.right.val, rightMin);
            return isValidBST(root.right) && root.val < rightMin;
        }
        if (root.right == null) {
            leftMax = Math.max(root.left.val, leftMax);
            return isValidBST(root.left) && root.val > leftMax;
        }
        return isValidBST(root.left) && isValidBST(root.right)
                && root.val > leftMax && root.val < rightMin;
    }
}*/
