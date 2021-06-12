import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution47 {
}

// 注意used数组的使用
class Solution47_1 {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    int[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return res;
        used = new int[nums.length];
        Arrays.sort(nums);
        backtracking(nums);
        return res;
    }

    public void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) continue;
            if (used[i] == 0) {
                used[i] = 1;
                path.add(nums[i]);
                backtracking(nums);
                used[i] = 0;
                path.remove(path.size() - 1);
            }
        }
    }
}