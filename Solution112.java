public class Solution112 {
    public static void main(String[] args) {
        Solution112_1 s1 = new Solution112_1();
        //Solution112_2 s2 = new Solution112_2();
        Solution112_3 s3 = new Solution112_3();

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        /*
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;

         */
        System.out.println(s1.hasPathSum(t1,38));
    }
}

// 可以用Top Down，但是要从上往下减，看最后的结果是否是叶子节点的值
// 注意Top Down一般没有返回值！！因为没法从底层（最内层）直接返回最终需要的值，还要一层层往外跳
// 也可以用Bottom Up

// 解1：Top Down
class Solution112_1 {
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int path = 0;
        if (root == null) return false;
        findPath(root, path, targetSum);
        return flag;
    }

    public void findPath(TreeNode node, int pathSum, int targetSum) {
        pathSum += node.val;
        if (node.left == null && node.right == null && pathSum == targetSum) {
            flag = true;
        }
        if (node.left != null) {
            findPath(node.left, pathSum, targetSum);
        }
        if (node.right != null) {
            findPath(node.right, pathSum, targetSum);
        }
    }
}

// 解2: Bottom Up(???)不太适合这道题
/*
class Solution112_2 {
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int pathSum = 0;
        findPath(root, pathSum, targetSum);
        return flag;
    }

    public boolean findPath(TreeNode node, int pathSum, int targetSum) {
        if (node.left != null && node.right != null) {
            // 先到最底层，没有数据的处理
            boolean left = findPath(node.left, pathSum, targetSum);
            boolean right = findPath(node.right, pathSum, targetSum);
        }
    }
}

 */


// 解3：这个也是Top Down，数据是往下传的（从上往下减）,简洁了一些而已
class Solution112_3 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // base case
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // get information from children
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);

        /*
        if (!hasPathSum(root.left, targetSum) && !hasPathSum(root.right, targetSum)) {
            targetSum -= root.val;
        }
        return targetSum == root.val;

         */
    }
}