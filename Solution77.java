import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution77 {
    public static void main(String[] args) {
        Solution77_1 s = new Solution77_1();
        s.combine(4,2);
    }
}

// 解1：经典回溯（暴力列举，复杂度高）
// 注意，添加到res中的path随着改变怎么办，最后输出的全是空序列
class Solution77_1 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> path = new LinkedList<>(); // 存放当前路径的结果，最后要添加到res里面
    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || k > n) return res;
        int start = 1;
        backtracking(n, k, start);
        return res;
    }

    public void backtracking(int n, int k, int start) {
        if (path.size() == k) {
            res.add(new LinkedList<Integer>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

// 解2：解1的剪枝
// 把29行的上界由 n 改为 n - (k - path.size()) + 1 ，减少不必要的遍历