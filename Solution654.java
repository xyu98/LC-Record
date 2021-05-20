import java.util.Arrays;

public class Solution654 {
    public static void main(String[] args) {

    }
}

// 通过，但是时间空间复杂度都较高
// 时间复杂度O(N^2) 空间复杂度O(N^2)——对数组进行了复制
class Solution654_1 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);

        int j = 0, k = 0, flag = 0;
        TreeNode maxNode = new TreeNode(0);
        maxNode.val = nums[0];
        for (k = 0; k < nums.length; k++) {
            flag = 0;
            if (nums[k] > maxNode.val) {
                maxNode.val = nums[k];
                flag = 1;
            }
            if (flag == 1) j = k;
        }
        int[] numsLeft = Arrays.copyOfRange(nums, 0, j);
        int[] numsRight;
        if (j != nums.length - 1) {
            numsRight = Arrays.copyOfRange(nums, j + 1, nums.length);
        }
        else {
            numsRight = new int[0];
        }
        maxNode.left = constructMaximumBinaryTree(numsLeft);
        maxNode.right = constructMaximumBinaryTree(numsRight);
        return maxNode;
    }
}

// 对以上解法进行优化，不复制数组，只传递下标（和归并排序有相似之处）
class Solution654_2 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    public TreeNode construct(int[] nums, int l, int r) {
        if (l == r)
            return null;
        int max_i = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = construct(nums, l, max_i);
        root.right = construct(nums, max_i + 1, r);
        return root;
    }
    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i])
                max_i = i;
        }
        return max_i;
    }
}

// 还能继续简化，思路相同
class Solution654_3 {
    /* 主函数 */
    TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    /* 将 nums[lo..hi] 构造成符合条件的树，返回根节点 */
    TreeNode build(int[] nums, int lo, int hi) {
        // base case
        if (lo > hi) {
            return null;
        }

        // 找到数组中的最大值和对应的索引
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);
        // 递归调用构造左右子树
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);

        return root;
    }
}