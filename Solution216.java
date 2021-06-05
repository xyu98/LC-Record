import java.util.LinkedList;
import java.util.List;

public class Solution216 {
    public static void main(String[] args) {
        Solution216_1 s = new Solution216_1();
        s.combinationSum3(3,7);
    }
}

class Solution216_1 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n < k || n > k * 9 ) return res;
        backtracking(1, k, n, 0);
        return res;
    }

    public void backtracking(int start, int k, int n, int sum) {
        if (sum > n) return;
        if (path.size() == k && sum == n) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (path.size() == k) return;
        for (int i = start; i <= 9; i++) {
            sum = sum + i;
            path.add(i);
            backtracking(i + 1, k, n, sum);
            sum = sum - i;
            path.remove(path.size() - 1);
        }
    }
}