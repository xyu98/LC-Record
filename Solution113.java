import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution113 {
    public static void main(String[] args) {

    }
}

// 有输出要求，只能Top Down
// 数组怎么清空不合适的路径？
/*
class Solution113_1 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfsPathSum(root, targetSum);
        return res;
    }

    public void dfsPathSum(TreeNode root, int targetSum) {
        if (root == null) return;
        if (root.left == null && root.right == null && root.val == targetSum) res.add(list);
        if (root.left != null) {
            list.add(root.val);
            dfsPathSum(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            list.add(root.val);
            dfsPathSum(root.right, targetSum - root.val);
        }
    }
}*/

class Solution113_1 {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    // 这个是记录根节点到当前节点路径的，每遍历一条路径都会存到path中，最后由pollLast全部弹出！！！
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.pollLast();
    }
}