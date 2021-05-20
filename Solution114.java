public class Solution114 {
    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        tn1.right = tn2;
        tn2.left = tn3;

        Solution114_1 s = new Solution114_1();
        s.flatten(tn1);
        System.out.println(tn1);
        System.out.println(tn1.left);
        System.out.println(tn1.right);
        System.out.println(tn1.right.left);
        System.out.println(tn1.right.right);
    }
}


class Solution114_1 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        if (root.left == null) return;
        TreeNode tmp1 = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp1;

        /*
        // 这样也可以，创建一个新的指针p指向root节点，也是对root节点进行操作
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }*/
    }
}