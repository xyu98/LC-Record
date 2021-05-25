import java.lang.management.GarbageCollectorMXBean;

public class Solution450 {
}

class Solution450_1 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            // 最难的是A有两个子节点的情况，为了不破坏BST的性质，
            // A必须找到左子树中最大的那个节点，或者右子树中最小的那个节点来接替自己
            // 左右子树也是BST，最大值和最小值可以直接拿，不用遍历
            // 注意，怎么把该节点从原来的位置去掉？？
            else {
                TreeNode minNode = getMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;
    }

    // 取右子树的最小值来替换
    public TreeNode getMin(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }
}