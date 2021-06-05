import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution39 {
    public static void main(String[] args) {
        Solution39_1 s = new Solution39_1();
        int[] candidates = {2,7,6,3,5,1};
        s.combinationSum(candidates, 9);
    }
}

// 解法1 解法2区别在于【去重复】的手段不同。
class Solution39_1 {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, 0, 0, target);
        return res;
    }

    public void backtracking(int[] candidates, int index, int sum, int target) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
            path.add(candidates[i]);
            sum = sum + candidates[i];
            backtracking(candidates, i, sum, target);
            sum = sum - candidates[i];
            path.remove((Integer) candidates[i]);
        }
    }
}

class Solution39_2 {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, 0, 0, target);
        return res;
    }

    public void backtracking(int[] candidates, int index, int sum, int target) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
            path.add(candidates[i]);
            sum = sum + candidates[i];
            backtracking(candidates, i, sum, target);
            sum = sum - candidates[i];
            path.remove(path.size() - 1);
        }
    }
}