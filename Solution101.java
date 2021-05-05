import java.util.ArrayList;

public class Solution101 {
    public static void main(String[] args) {
        Solution101_2 s = new Solution101_2();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(2);
        t1.left = t2;
        t2.left = t3;
        t1.right = t4;
        t4.left = t5;
        System.out.println(s.isSymmetric(t1));
    }
}

// 中序遍历，无法解决问题！！！
class Solution101_1 {
    ArrayList<Integer> treeList = new ArrayList<>();

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        midOrderTraverse(root);
        for (int i = 0, j = treeList.size() - 1; i <= j; i++, j--) {
            if (!treeList.get(i).equals(treeList.get(j))) return false;
        }
        return true;
    }

    public void midOrderTraverse(TreeNode root) {
        if (root != null) {
            midOrderTraverse(root.left);
            treeList.add(root.val);
            midOrderTraverse(root.right);
        }
    }
}

// 解1：递归【思路没找到】
// 当前节点需要从左右子树获取什么信息？当前节点的两个子树是否是镜像对称（难想）
// 当前节点需要传递什么信息？以当前节点为根节点的树是否是镜像对称
// 以上两个条件必须同时满足，所以是 &&
class Solution101_2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        else {
            return helper(root.left, root.right);  // 递归的是当前节点的左右子树
        }
    }

    // 这个是信息的process方法
    public boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == node2)  // 当前节点的左右子树相等，返回true
            return true;
        if (node1 == null || node2 == null) // 当前节点左右子树不相等且有一个为空，必不对称
            return false;
        // 两棵子树都不为空，这是最难的情况
        // 需要满足1.左右节点的值相等，2.左子树的左右子树镜像对称，右子树的左右子树镜像对称
        // 特别注意这里的逻辑！！必须跨过中间的根节点和对面比较！！
        return (node1.val == node2.val)
                && (helper(node1.left, node2.right))
                && (helper(node1.right, node2.left));
    }
}
