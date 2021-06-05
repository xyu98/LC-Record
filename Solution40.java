import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution40 {
    public static void main(String[] args) {
        Solution40_1 s = new Solution40_1();
        int[] candidates = {2,5,2,1,2};
        s.combinationSum2(candidates,5);
    }
}

class Solution40_1 {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            sum = sum + candidates[i];
            backtracking(candidates, i + 1, sum, target);
            sum = sum - candidates[i];
            path.remove(path.size() - 1);
        }
    }
}