package _crackingthecodinginterview;

public class TreeNode {
    int val;
    String str;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }

    //TreeNode(String str) { this.str = str; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}