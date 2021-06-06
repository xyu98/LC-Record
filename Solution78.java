import java.util.LinkedList;
import java.util.List;

public class Solution78 {
}

class Solution78_1 {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return res;
        res.add(new LinkedList<>(path));
        backtracking(0, nums);
        return res;
    }

    public void backtracking(int startIndex, int[] nums) {
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new LinkedList<>(path));
            backtracking(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}