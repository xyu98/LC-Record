import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Solution538 {
}

class Solution538_1 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        if (root.right != null) convertBST(root.right);
        sum = sum + root.val;
        root.val = sum;
        if (root.left != null) convertBST(root.left);
        return root;
    }
}