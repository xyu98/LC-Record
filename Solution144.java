import java.util.ArrayList;
import java.util.List;

public class Solution144 {
    public static void main(String[] args) {
        Soluition144_1 s = new Soluition144_1();
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        tn1.left = null;
        tn1.right = tn2;
        tn2.left = tn3;
        tn2.right = null;
        System.out.println(s.preorderTraversal(tn1));
    }
}

class Soluition144_1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.left != null) preOrder(root.left, list);
            if (root.right != null) preOrder(root.right, list);
        }
    }
}

