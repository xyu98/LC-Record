public class Solution222 {
    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        /*TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);*/
        tn1.left = tn2;
        tn1.right = tn3;
/*        tn2.left = tn4;
        tn2.right = tn5;
        tn3.left = tn6;*/
        Solution222_3 s = new Solution222_3();
        System.out.println(s.countNodes(tn1));
    }
}

// 解1：普适解法。时间O(N), 空间O(N), N为节点总个数
class Solution222_1 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

// 解2：利用完全二叉树的特性
// 只要利用其特性，时间复杂度都是一样的
class Solution222_2 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = 0, rightHeight = 0;
        TreeNode l = root, r = root;
        while (l != null) {
            l = l.left;
            leftHeight++;
        }
        while (r != null) {
            r = r.right;
            rightHeight++;
        }
        if (leftHeight == rightHeight) return (int)(Math.pow(2,leftHeight)) - 1;
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

// 解3：完全二叉树特性 + 位运算
// 先求出除最后一层之外的数目，再计算最后一层的个数(可以用二分法)
class Solution222_3 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int level = 0;
        TreeNode node = root;
        while (node != null) {
            node = node.left;
            level++;
        }
        int low = 1 << (level - 1), high = (1 << level) - 1;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (exists(root, level, mid)) low = mid;
            else high = mid - 1;
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 2);
        while (root != null && bits > 0) {
            if ((k & bits) == 0) root = root.left;
            else root = root.right;
            bits = bits >> 1;
        }
        return root != null;
    }
}

/*
位运算解释：
    1            h = 0
   / \
  2   3          h = 1
 / \  /
4  5 6           h = 2
现在这个树中的值都是节点的编号，最底下的一层的编号是[2^h ，2^h - 1]，现在h = 2，也就是4, 5, 6, 7。
4, 5, 6, 7对应二进制分别为 100 101 110 111 不看最左边的1，从第二位开始，0表示向左，1表示向右，正好可以表示此节点相对于根的位置。
比如4的 00 就表示从根节点 向左 再向左。6的 10 就表示从根节点 向右 再向左

那么想访问最后一层的节点就可以从节点的编号的二进制入手。从第二位开始的二进制位表示了最后一层的节点相对于根节点的位置。
那么就需要一个bits = 2^(h - 1) 上面例子中的bits就是2，对应二进制为010。这样就可以从第二位开始判断。（树三层高，需要向左或向右走两次才能到叶子）
比如看5这个节点存不存在，先通过位运算找到编号为5的节点相对于根节点的位置。010 & 101 发现第二位是0，说明从根节点开始，第一步向左走。
之后将bit右移一位，变成001。001 & 101 发现第三位是1，那么第二步向右走。
最后bit为0，说明已经找到编号为5的这个节点相对于根节点的位置，看这个节点是不是空，不是说明存在，exist返回真
编号为5的节点存在，说明总节点数量一定大于等于5。所以二分那里low = mid

再比如看7存不存在，010 & 111 第二位为1，第一部从根节点向右；001 & 111 第三位也为1，第二步继续向右。
然后判断当前节点是不是null，发现是null，exist返回假。
编号为7的节点不存在，说明总节点数量一定小于7。所以high = mid - 1

 */