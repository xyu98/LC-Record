import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution90 {
    public static void main(String[] args) {
        Solution90_1 s = new Solution90_1();
        int[] nums = {1,2,2};
        s.subsetsWithDup(nums);
    }
}

class Solution90_1 {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    int[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        used = new int[nums.length];
        res.add(new LinkedList<>(path));
        backtracking(0, nums);
        return res;
    }

    public void backtracking(int startIndex, int[] nums) {
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1] && used[i - 1] == 0) continue;
            path.add(nums[i]);
            used[i] = 1;
            res.add(new LinkedList<>(path));
            backtracking(i + 1, nums);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}