public class Solution701 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        Solution701_2 s = new Solution701_2();
        System.out.println(s.insertIntoBST(t1, 5));
    }
}


class Solution701_1 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        insert(root, null, val);
        return root;
    }

    public void insert(TreeNode root, TreeNode parent, int val) {
        if (root == null) {
            root = new TreeNode(val);
            if (val > parent.val) parent.right = root;
            else parent.left = root;
        }
        if (root.val > val) insert(root.left, root, val);
        if (root.val < val) insert(root.right, root, val);
    }
}

// 注意，为什么这样插不进来？？
// 因为没有return，新建立的节点并没有和上层建立联系！！
// return会将当前root返回到上一层的root.left/right从而把这个节点连接上
// return的内容，就是接替当前节点root的内容
class Solution701_1_1 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        insert(root, val);
        return root;
    }

    public void insert(TreeNode root, int val) {
        if (root == null) root = new TreeNode(val); // 只是建立了一个孤立的节点
        if (root.val > val) insert(root.left, val);
        if (root.val < val) insert(root.right, val);
    }
}

// 这才是正常解法
class Solution701_2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }
}