import java.util.LinkedList;
import java.util.List;

public class Solution46 {
}

// 解1：使用contains判断是否已包含，搜索复杂度为O(n)
class Solution86_1 {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return res;
        backtracking(nums);
        return res;
    }

    public void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
                backtracking(nums);
                path.remove(path.size() - 1);
            }
        }
    }
}

// 解2：使用一个used数组判断是否已包含，搜索复杂度为O(1)
class Solution86_2 {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    int[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return res;
        used = new int[nums.length];
        backtracking(nums);
        return res;
    }

    public void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
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